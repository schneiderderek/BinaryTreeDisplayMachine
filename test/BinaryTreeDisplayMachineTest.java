import org.junit.Test;

import components.stopwatch.Stopwatch;
import components.stopwatch.Stopwatch1;

public class BinaryTreeDisplayMachineTest {

    @Test
    public void test() {
        Stopwatch sw = new Stopwatch1();

        sw.start();
        BinaryTreeDisplayMachine<Integer> dis1 = new BinaryTreeDisplayMachine1<>(
                255);
        sw.stop();

        System.out.println("Running time of const : " + sw.elapsed());

        sw.clear();

        sw.start();
        dis1.generateToFile("output.txt");
        sw.stop();

        System.out.println("Running time of display : " + sw.elapsed());
    }

}
