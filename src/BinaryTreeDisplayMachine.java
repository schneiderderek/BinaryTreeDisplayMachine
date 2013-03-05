/**
 * Generates a .txt file in root project directory of the inputed heap.
 * 
 * @author Derek Schneider
 * 
 * @param <T>
 *            Generic type
 */
public interface BinaryTreeDisplayMachine<T> {
    /**
     * Generates an ASCII display of the {@code BinaryTree} to the
     * {@code fileName}.
     * 
     * @param fileName
     *            {@code String} of the filename to be written to.
     */
    void generateToFile(String fileName);

    /**
     * Generates an ASCII display of the {@code BinaryTree} to the console.
     */
    void generateToConsole();
}
