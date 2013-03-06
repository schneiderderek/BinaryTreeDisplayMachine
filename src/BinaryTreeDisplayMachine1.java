import components.array.Array;
import components.array.Array1L;
import components.binarytree.BinaryTree;
import components.random.Random;
import components.random.Random1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * 
 * @author Derek Schneider
 * 
 * @param <T>
 */
public final class BinaryTreeDisplayMachine1<T> implements
        BinaryTreeDisplayMachine<T> {

    /**
     * The heap. Represented as an {@code Array<T>}
     * 
     * @requires T is of type BinaryTree || Array
     */
    private Array<T> tree;

    /**
     * Default Heap size.
     */
    private static final int defaultHeapSize = 20;

    /**
     * The space reserved for nodes in the tree.
     */
    private static final int nodeSpace = 10;

    /**
     * Total height of the tree
     */
    private int totalHeight;

    /**
     * Creates a new representation of this.
     * 
     * @param size
     *            Size of the {@code BinaryTree} to be created
     */
    @SuppressWarnings("unchecked")
    private void createNewRep(int size) {
        this.tree = new Array1L<T>(size);

        Random rnd = new Random1L();
        for (int i = 0; i < size; i++) {
            // This is really bad... (Cast on cast)
            T entry = (T) (Integer) Math.abs((rnd.nextInt() * size));
            this.tree.setEntryAt(i, entry);
        }

        this.totalHeight = determineHeightFromArray(this.tree);
    }

    /**
     * Initializes the representation of BinaryTreeDisplayMachine.
     * 
     * @param array
     *            Array to use for initialization
     */
    private void createNewRep(Array<T> array) {
        this.tree = new Array1L<T>(array.length());

        for (int i = 0; i < array.length(); i++) {
            this.tree.setEntryAt(i, array.entryAt(i));
        }

        this.totalHeight = determineHeightFromArray(array);
    }

    /**
     * Initializes the representation of BinaryTreeDisplayMachine.
     * 
     * @param tree
     *            {@code BinaryTree} to use for initialization
     */
    private void createNewRep(BinaryTree<T> tree) {
        this.tree = new Array1L<T>(tree.size());

        this.totalHeight = tree.height();

        this.buildArrayFromTree(this.tree, tree, 0);

        if (tree.root().toString().length() > nodeSpace) {
            System.out.println("Warning, toString representation"
                    + " of nodes is greater than 10.");
        }
    }

    private static <T> int determineHeightFromArray(Array<T> array) {
        int height = 0;

        for (int i = 0; i < array.length(); i = 2 * i + 1) {
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
    private void buildArrayFromTree(Array<T> array, BinaryTree<T> t, int rootPos) {

        if (t.size() > 0) {
            BinaryTree<T> left = t.newInstance();
            BinaryTree<T> right = t.newInstance();

            T treeRoot = t.disassemble(left, right);

            array.setEntryAt(rootPos, treeRoot);

            this.buildArrayFromTree(array, left, 2 * rootPos + 1);
            this.buildArrayFromTree(array, right, 2 * rootPos + 2);

            t.assemble(treeRoot, left, right);
        }
    }

    /**
     * Returns a string containing the number of spaces equal to {@code number}.
     * 
     * @param number
     *            The number of spaces to have in the {@code String}
     * 
     * @return {@code String} with the correct number of spaces
     */
    private static <T> String spaceBuilder(int number) {
        assert number >= 0 : "Violation of number >= 0";

        StringBuilder string = new StringBuilder(number);

        while (string.length() < number) {
            string.insert(0, ' ');
        }

        // Because of the condition of the loop above, this is unlikely to fail.
        assert string.length() == number : "Incorrect number of spaces.";

        return new String(string);
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
    private static <T> String nodeFormater(T node) {
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
     * 
     * @param tree
     * @param out
     * @param root
     */
    private static <T> void displayTree(Array<T> tree, SimpleWriter out,
            int currentHeight) {
        assert tree != null : "Violation of tree != null";
        assert out != null : "Violation of out != null";
        assert out.isOpen() : "Violation of out is open";

        for (int leftMostRoot = 0, rowLevel = currentHeight; leftMostRoot < tree
                .length(); leftMostRoot = 2 * leftMostRoot + 1, rowLevel--, currentHeight--) {
            // Print out the nodes in the tree
            displayRowOfNodes(tree, out, leftMostRoot, rowLevel);
            out.println();
            displayRowOfBranches(out, leftMostRoot, rowLevel);
            out.println();
        }
    }

    /**
     * Displays the row of branches corresponding to the current height of the
     * tree
     * 
     * @param out
     * @param rowLevel
     */
    private static <T> void displayRowOfBranches(SimpleWriter out,
            int leftMostNode, int height) {
        assert out != null : "Violation of out != null";
        assert out.isOpen() : "Violation of out is open";

        out.print(spaceBuilder(calculateBufferForHeight(height) - 1));

        for (int i = leftMostNode; i <= (2 * leftMostNode); i++) {
            out.print('/' + spaceBuilder(nodeSpace) + '\\'
                    + spaceBuilder(calculateBufferForHeight(height + 1) - 2));
        }
    }

    /**
     * 
     * @param tree
     * @param out
     * @param leftMostRoot
     * @param rowLevel
     */
    private static <T> void displayRowOfNodes(Array<T> tree, SimpleWriter out,
            int leftMostRoot, int height) {
        assert tree != null : "Violation of tree != null";
        assert out != null : "Violation of out != null";
        assert out.isOpen() : "Violation of out is open";

        out.print(spaceBuilder(calculateBufferForHeight(height)));

        // Print all of the nodes
        for (int i = leftMostRoot; i <= (leftMostRoot * 2); i++) {
            out.print(nodeFormater(tree.entryAt(i))
                    + spaceBuilder(calculateBufferForHeight(height + 1)));
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
    private static <T> int calculateBufferForHeight(int height) {

        if (height > 1) {
            return 2 * calculateBufferForHeight(height - 1) + 10;
        } else {
            return 1;
        }
    }

    /**
     * Generates a random complete {@code BinaryTree} of Default size.
     */
    public BinaryTreeDisplayMachine1() {
        this.createNewRep(defaultHeapSize);
    }

    /**
     * Generates a random complete {@code BinaryTree} with the specific
     * {@code size}.
     * 
     * @param size
     *            Size of the random tree to be created
     */
    public BinaryTreeDisplayMachine1(int size) {
        this.createNewRep(size);
    }

    /**
     * 
     * @param heap
     */
    public BinaryTreeDisplayMachine1(Array<T> heap) {
        this.createNewRep(heap);
    }

    /**
     * 
     * @param heap
     */
    public BinaryTreeDisplayMachine1(BinaryTree<T> heap) {
        this.createNewRep(heap);
    }

    @Override
    public void generateToFile(String fileName) {
        assert fileName != null : "Violation of filename != null";
        assert fileName.length() > 0 : "Violation of filename is a file";

        SimpleWriter out = new SimpleWriter1L(fileName);

        displayTree(this.tree, out, this.totalHeight);

        out.close();
    }

    @Override
    public void generateToConsole() {
        SimpleWriter out = new SimpleWriter1L();

        displayTree(this.tree, out, this.totalHeight);

        out.close();
    }

    @Override
    public String toString() {
        return this.tree.toString();
    }

}
