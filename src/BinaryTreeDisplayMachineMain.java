import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Program to run BinaryTreeDisplayMachine examples on.
 * 
 * @author Derek Schneider
 * 
 */
public class BinaryTreeDisplayMachineMain {

    /**
     * @param args
     */
    public static void main(String[] args) {

        SimpleWriter out = new SimpleWriter1L();

        BinaryTreeDisplayMachine<Integer> display = new BinaryTreeDisplayMachine1<Integer>(
                63);

        display.generateToConsole();

        out.close();

        BinaryTreeDisplayMachine<Integer> display1 = new BinaryTreeDisplayMachine1<Integer>(
                255);

        display1.generateToFile("output.txt");
    }
}
