import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import components.array.Array;
import components.binarytree.BinaryTree;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * 
 * @author Derek Schneider
 * 
 * 
 *         NOTE: This implementation is based on the Java Standard Libraries [Or
 *         it will be after some time]
 * 
 *         Performance Notes: An {@code String} is used for the longest string
 *         buffer because the substring method for {@code String} runs in
 *         constant time and requires little additional memory
 * 
 *         Runs in cn in theta(n) time (where c < 1) [What I estimate]
 * 
 * @param <T>
 */
public final class BinaryTreeDisplayMachine2<T> implements
        BinaryTreeDisplayMachine<T> {

    /**
     * The heap. Represented as an {@code Array<T>}
     * 
     * @requires T is of type BinaryTree || Array
     */
    private List<T> tree;

    /**
     * Default Heap size.
     */
    private static final int defaultHeapSize = 20;

    /**
     * The space reserved for nodes in the tree.
     */
    private int nodeSpace;

    /**
     * Total height of the tree
     */
    private int totalHeight;

    /**
     * {@code String} Used to cache the largest buffer space
     */
    private String longestBuffer;

    /**
     * {@code Array} used to cache sizes for all of the buffers
     */
    private int[] bufferSizes;

    /**
     * {@code String} for a space
     */
    private static final String singleSpace = " ";

    /**
     * Creates a new representation of this.
     * 
     * @param size
     *            Size of the {@code BinaryTree} to be created
     */
    @SuppressWarnings("unchecked")
    private void createNewRep(int size) {
        this.tree = new ArrayList<T>(size);

        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            // This is really bad... (Cast on cast)
            T entry = (T) (Integer) Math.abs((rnd.nextInt() * size));
            this.tree.set(i, entry);
            int currentLength = this.tree.get(i).toString().length();

            // Sets the nodeSpace to the longest string rep in the array
            if (currentLength > this.nodeSpace) {
                this.nodeSpace = currentLength;
            }
        }
    }

    /**
     * @param {@code Array} Array representation of Binary Tree
     */
    private void createPartialRep(List<T> array) {
        assert array != null : "Violation of array /= null";

        this.totalHeight = determineHeightFromArray(array);
        this.longestBuffer = createLargestBufferString(this.totalHeight + 1,
                this.nodeSpace);
        this.bufferSizes = new int[this.totalHeight + 2];
    }

    /**
     * This will create a string of spaces, with the number of spaces equal to
     * the max number of spaces needed for any buffer in the display generation
     * process.
     * 
     * @param totalHeight
     *            The total height of the tree
     * @param nodeSpace
     *            The amount of space reserved for each node
     * @return {@code String} Returns the string of the biggest buffer needed to
     *         print the Tree
     */
    private static String createLargestBufferString(int totalHeight,
            int nodeSpace) {
        int length = calculateBufferForHeight(totalHeight, nodeSpace);
        StringBuilder temp = new StringBuilder();

        while (length > 0) {
            temp.append(singleSpace);
            length--;
        }
        return new String(temp);
    }

    /**
     * Determines the height of the tree from an {@code Array}
     * 
     * @param array
     *            Incoming {@code Array} to determine the height
     * 
     * @return {@code int} the height of the tree
     */
    private static <T> int determineHeightFromArray(List<T> array) {
        int height = 0;

        for (int i = 0; i < array.size(); i = 2 * i + 1) {
            height++;
        }

        return height;
    }

    /**
     * Takes a {@code BinaryTree} and creates an {@Array}, where the top
     * root node is 0 and its children are 2*root +1 and 2*top +2.
     * 
     * @param array
     *            The {@code Array} to be filled
     * @param t
     *            The {@code BinaryTree} to fill the array with}
     * 
     * @param rootPos
     *            The root of the current sub-tree
     */
    private void buildArrayFromTree(List<T> array, BinaryTree<T> t, int rootPos) {

        if (t.size() > 0) {
            BinaryTree<T> left = t.newInstance();
            BinaryTree<T> right = t.newInstance();

            T treeRoot = t.disassemble(left, right);

            array.set(rootPos, treeRoot);

            int currentLength = array.get(rootPos).toString().length();

            // Sets the nodeSpace to the longest string rep in the array
            if (currentLength > this.nodeSpace) {
                this.nodeSpace = currentLength;
            }

            this.buildArrayFromTree(array, left, 2 * rootPos + 1);
            this.buildArrayFromTree(array, right, 2 * rootPos + 2);

            t.assemble(treeRoot, left, right);
        }
    }

    /**
     * Adds blank spaces around the {@code toString()} of the incoming node. The
     * number of blank spaces added is:
     * {@code nodeSpace - node.toString().length()}. If this is an odd number,
     * then the extra space will show up on the left side.
     * 
     * @param node
     *            The node to add spaces around
     * 
     * @return {@code String} The formatted {@code String} with the correct
     *         spacing
     */
    private static <T> String nodeFormater(T node, int nodeSpace) {
        assert node != null : "Violation of node != null";

        StringBuilder string = new StringBuilder();

        string.append(node.toString());

        for (int i = 0; i < Math
                .floor((double) (nodeSpace - string.length()) / 2); i++) {
            string.insert(0, '*');
        }

        while (string.length() < nodeSpace) {
            string.insert(string.length(), '*');
        }

        // Because of the condition on the loop above, this is unlikely to fail.
        assert string.length() == nodeSpace : "Violation of string.length() == nodeSpace";

        return new String(string);
    }

    /**
     * Prints an {@code Array} in tree form with nodes and branches.
     * 
     * @param out
     *            Output stream to write to (Must be open)
     * @param currentHeight
     *            The current height in the {@code Tree}
     */
    private void displayTree(SimpleWriter out, int currentHeight) {
        assert this.tree != null : "Violation of tree != null";
        assert out != null : "Violation of out != null";
        assert out.isOpen() : "Violation of out is open";

        for (int leftMostRoot = 0, rowLevel = currentHeight; leftMostRoot < this.tree
                .size(); leftMostRoot = 2 * leftMostRoot + 1, rowLevel--, currentHeight--) {
            // Print out the nodes in the tree
            this.displayRowOfNodes(out, leftMostRoot, rowLevel);
            out.println();
            this.displayRowOfBranches(out, leftMostRoot, rowLevel);
            out.println();
        }
    }

    /**
     * Displays the row of branches corresponding to the current height of the
     * tree.
     * 
     * @param out
     *            Output stream (Must be open)
     * @param rowLevel
     *            What row of the tree is being printed (This may be different
     *            than the height of the tree).
     */
    private void displayRowOfBranches(SimpleWriter out, int leftMostNode,
            int height) {
        assert out != null : "Violation of out != null";
        assert out.isOpen() : "Violation of out is open";

        this.printBufferForHeight(height, out, -1);

        for (int i = leftMostNode; i <= (2 * leftMostNode); i++) {
            out.print("/");
            printSpaces(out, this.nodeSpace);
            out.print("\\");
            this.printBufferForHeight(height + 1, out, -2);
        }
    }

    /**
     * This will display a single row of properly formatted nodes, with correct
     * spacing and buffering between each.
     * 
     * @param height
     *            Height of the tree to display the row of nodes for
     * @param out
     *            Output stream (Must be open)
     * @param leftMostRoot
     *            Location of left most room in the current row
     */
    private void displayRowOfNodes(SimpleWriter out, int leftMostRoot,
            int height) {
        assert this.tree != null : "Violation of tree != null";
        assert out != null : "Violation of out != null";
        assert out.isOpen() : "Violation of out is open";

        this.printBufferForHeight(height, out, 0);

        // Print all of the nodes
        for (int i = leftMostRoot; i <= (leftMostRoot * 2); i++) {
            out.print(nodeFormater(this.tree.get(i), this.nodeSpace));

            this.printBufferForHeight(height + 1, out, 0);
        }
    }

    /**
     * Determine the number of spaces needed for the correct amount of spacing
     * between nodes of a specified height.
     * 
     * @param height
     *            The height to determine the number of spaces for
     * 
     * @return {@code int} the number of spaces
     */
    private static <T> int calculateBufferForHeight(int height, int nodeSpace) {

        if (height > 1) {
            return 2 * calculateBufferForHeight(height - 1, nodeSpace)
                    + nodeSpace;
        } else {
            return 1;
        }
    }

    /**
     * 
     * @param height
     * @param out
     */
    private void printBufferForHeight(int height, SimpleWriter out, int offset) {
        assert height != 0 : "Not a valid buffer space for height = 0";

        if (this.bufferSizes[height] == 0) {
            this.bufferSizes[height] = calculateBufferForHeight(height,
                    this.nodeSpace);
        }

        // Assert is placed here because this.bufferSizes[height] may be 0 and
        // the assertion would not fail in the case that it should have
        assert this.bufferSizes[height] + offset <= this.longestBuffer.length() : "Violation, substring larger than original.";

        out.print(this.longestBuffer.substring(0, this.bufferSizes[height]
                + offset));
    }

    /**
     * Prints the number of spaces ' ' specified to the output stream
     * 
     * @param out
     *            {@code SimpleWriter} output stream
     * 
     * @param number
     *            number of spaces to print
     */
    private static void printSpaces(SimpleWriter out, int number) {
        for (int i = 0; i < number; i++) {
            out.print(" ");
        }
    }

    /**
     * Generates a random complete {@code BinaryTree} of Default size.
     */
    public BinaryTreeDisplayMachine2() {
        this.createNewRep(defaultHeapSize);
        this.createPartialRep(this.tree);
    }

    /**
     * Generates a random complete {@code BinaryTree} with the specific
     * {@code size}.
     * 
     * @param size
     *            Size of the random tree to be created
     */
    public BinaryTreeDisplayMachine2(int size) {
        assert size > 0 : "Violation of size > 0";

        this.createNewRep(size);
        this.createPartialRep(this.tree);
    }

    /**
     * 
     * @param heap
     */
    public BinaryTreeDisplayMachine2(Array<T> heap) {
        assert heap != null : "Violation of heap != null";

        this.tree = new ArrayList<T>(heap.length());

        for (int i = 0; i < heap.length(); i++) {
            int currentLength = heap.entryAt(i).toString().length();

            // Sets the nodeSpace to the longest string rep in the array
            if (currentLength > this.nodeSpace) {
                this.nodeSpace = currentLength;
            }

            this.tree.set(i, heap.entryAt(i));
        }

        this.createPartialRep(this.tree);
    }

    /**
     * 
     * @param heap
     */
    public BinaryTreeDisplayMachine2(BinaryTree<T> heap) {
        assert heap != null : "Violation of heap != null";

        this.tree = new ArrayList<T>(heap.size());
        this.buildArrayFromTree(this.tree, heap, 0);

        this.createPartialRep(this.tree);
    }

    @Override
    public void generateToFile(String fileName) {
        assert fileName != null : "Violation of filename != null";
        assert fileName.length() > 0 : "Violation of filename is a file";

        SimpleWriter out = new SimpleWriter1L(fileName);

        this.displayTree(out, this.totalHeight);

        out.close();
    }

    @Override
    public void generateToConsole() {
        SimpleWriter out = new SimpleWriter1L();

        this.displayTree(out, this.totalHeight);

        out.close();
    }

    /**
     * Returns the {@code String} representation of {@code this}.
     * 
     * @return {@code String} Representation of this.
     */
    @Override
    public String toString() {
        return this.tree.toString();
    }

    @Override
    public boolean equals() {
        assert false : "Unsupported operation";
        return false;
    }
}
