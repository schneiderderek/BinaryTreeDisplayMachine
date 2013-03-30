import org.junit.Before;
import org.junit.Test;

import components.array.Array;
import components.array.Array1L;
import components.binarytree.BinaryTree;
import components.binarytree.BinaryTree1;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.stopwatch.Stopwatch;
import components.stopwatch.Stopwatch1;

public class BinaryTreeDisplayMachineTest {
    public static int current;
    public SimpleWriter out = new SimpleWriter1L("data/results.txt");

    @Before
    public void setUp() {
        current++;
    }

    @Test
    public void test1() {
        Stopwatch sw = new Stopwatch1();

        sw.start();
        BinaryTreeDisplayMachine<Integer> dis1 = new BinaryTreeDisplayMachine1<>(
                1);
        sw.stop();

        this.out.println("Running time of const : " + sw.elapsed());

        sw.clear();

        sw.start();
        dis1.generateToFile("tmp.txt");
        sw.stop();

        this.out.println("Running time of display : " + sw.elapsed());
    }

    @Test
    public void test3() {
        Stopwatch sw = new Stopwatch1();

        sw.start();
        BinaryTreeDisplayMachine<Integer> dis1 = new BinaryTreeDisplayMachine1<>(
                3);
        sw.stop();

        this.out.println("Running time of const : " + sw.elapsed());

        sw.clear();

        sw.start();
        dis1.generateToFile("tmp.txt");
        sw.stop();

        this.out.println("Running time of display : " + sw.elapsed());
    }

    @Test
    public void test7() {
        Stopwatch sw = new Stopwatch1();

        sw.start();
        BinaryTreeDisplayMachine<Integer> dis1 = new BinaryTreeDisplayMachine1<>(
                7);
        sw.stop();

        this.out.println("Running time of const : " + sw.elapsed());

        sw.clear();

        sw.start();
        dis1.generateToFile("tmp.txt");
        sw.stop();

        this.out.println("Running time of display : " + sw.elapsed());
    }

    @Test
    public void test15() {
        Stopwatch sw = new Stopwatch1();

        sw.start();
        BinaryTreeDisplayMachine<Integer> dis1 = new BinaryTreeDisplayMachine1<>(
                15);
        sw.stop();

        this.out.println("Running time of const : " + sw.elapsed());

        sw.clear();

        sw.start();
        dis1.generateToFile("tmp.txt");
        sw.stop();

        this.out.println("Running time of display : " + sw.elapsed());
    }

    @Test
    public void test31() {
        Stopwatch sw = new Stopwatch1();

        sw.start();
        BinaryTreeDisplayMachine<Integer> dis1 = new BinaryTreeDisplayMachine1<>(
                31);
        sw.stop();

        this.out.println("Running time of const : " + sw.elapsed());

        sw.clear();

        sw.start();
        dis1.generateToFile("tmp.txt");
        sw.stop();

        this.out.println("Running time of display : " + sw.elapsed());
    }

    @Test
    public void test63() {
        Stopwatch sw = new Stopwatch1();

        sw.start();
        BinaryTreeDisplayMachine<Integer> dis1 = new BinaryTreeDisplayMachine1<>(
                63);
        sw.stop();

        this.out.println("Running time of const : " + sw.elapsed());

        sw.clear();

        sw.start();
        dis1.generateToFile("tmp.txt");
        sw.stop();

        this.out.println("Running time of display : " + sw.elapsed());
    }

    @Test
    public void test127() {
        Stopwatch sw = new Stopwatch1();

        sw.start();
        BinaryTreeDisplayMachine<Integer> dis1 = new BinaryTreeDisplayMachine1<>(
                127);
        sw.stop();

        this.out.println("Running time of const : " + sw.elapsed());

        sw.clear();

        sw.start();
        dis1.generateToFile("tmp.txt");
        sw.stop();

        this.out.println("Running time of display : " + sw.elapsed());
    }

    @Test
    public void test255() {
        Stopwatch sw = new Stopwatch1();

        sw.start();
        BinaryTreeDisplayMachine<Integer> dis1 = new BinaryTreeDisplayMachine1<>(
                255);
        sw.stop();

        this.out.println("Running time of const : " + sw.elapsed());

        sw.clear();

        sw.start();
        dis1.generateToFile("tmp.txt");
        sw.stop();

        this.out.println("Running time of display : " + sw.elapsed());
    }

    @Test
    public void test511() {
        Stopwatch sw = new Stopwatch1();

        sw.start();
        BinaryTreeDisplayMachine<Integer> dis1 = new BinaryTreeDisplayMachine1<>(
                511);
        sw.stop();

        this.out.println("Running time of const : " + sw.elapsed());

        sw.clear();

        sw.start();
        dis1.generateToFile("tmp.txt");
        sw.stop();

        this.out.println("Running time of display : " + sw.elapsed());
    }

    @Test
    public void test1023() {
        Stopwatch sw = new Stopwatch1();

        sw.start();
        BinaryTreeDisplayMachine<Integer> dis1 = new BinaryTreeDisplayMachine1<>(
                1023);
        sw.stop();

        this.out.println("Running time of const : " + sw.elapsed());

        sw.clear();

        sw.start();
        dis1.generateToFile("tmp.txt");
        sw.stop();

        this.out.println("Running time of display : " + sw.elapsed());
    }

    @Test
    public void test2047() {
        Stopwatch sw = new Stopwatch1();

        sw.start();
        BinaryTreeDisplayMachine<Integer> dis1 = new BinaryTreeDisplayMachine1<>(
                2047);
        sw.stop();

        this.out.println("Running time of const : " + sw.elapsed());

        sw.clear();

        sw.start();
        dis1.generateToFile("tmp.txt");
        sw.stop();

        this.out.println("Running time of display : " + sw.elapsed());
    }

    @Test
    public void test4095() {
        Stopwatch sw = new Stopwatch1();

        sw.start();
        BinaryTreeDisplayMachine<Integer> dis1 = new BinaryTreeDisplayMachine1<>(
                4095);
        sw.stop();

        this.out.println("Running time of const : " + sw.elapsed());

        sw.clear();

        sw.start();
        dis1.generateToFile("tmp.txt");
        sw.stop();

        this.out.println("Running time of display : " + sw.elapsed());
    }

    @Test
    public void test8191() {
        Stopwatch sw = new Stopwatch1();

        sw.start();
        BinaryTreeDisplayMachine<Integer> dis1 = new BinaryTreeDisplayMachine1<>(
                8191);
        sw.stop();

        this.out.println("Running time of 8191 const : " + sw.elapsed());

        sw.clear();

        sw.start();
        dis1.generateToFile("tmp.txt");
        sw.stop();

        this.out.println("Running time of display : " + sw.elapsed());
    }

    /*
     * FOR PERFORMANCE ONLY
     */
    // @Test
    // public void test1048575() {
    // Stopwatch sw = new Stopwatch1();
    //
    // sw.start();
    // BinaryTreeDisplayMachine<Integer> dis1 = new BinaryTreeDisplayMachine1<>(
    // 1048575);
    // sw.stop();
    //
    // this.out.println("Running time of 1048575 const : " + sw.elapsed());
    //
    // sw.clear();
    //
    // sw.start();
    // dis1.generateToFile("tmp.txt");
    // sw.stop();
    //
    // this.out.println("Running time of display : " + sw.elapsed());
    // }

    @Test
    public void testUserDefArrayBase() {
        Array<String> array = new Array1L<>(1);
        array.setEntryAt(0, "ROOT");

        BinaryTreeDisplayMachine<String> display = new BinaryTreeDisplayMachine1<>(
                array);

        display.generateToConsole();

    }

    @Test
    public void testUserDefArraySmall() {
        Array<String> array = new Array1L<>(3);
        array.setEntryAt(0, "ROOT");
        array.setEntryAt(1, "LEFT");
        array.setEntryAt(2, "RIGHT");

        BinaryTreeDisplayMachine<String> display = new BinaryTreeDisplayMachine1<>(
                array);

        display.generateToConsole();

    }

    @Test
    public void testUserDefinedTreeBase() {
        BinaryTree<String> subtree = new BinaryTree1<>();
        BinaryTree<String> left = subtree.newInstance();
        BinaryTree<String> right = subtree.newInstance();

        subtree.assemble("ROOT", left, right);

        BinaryTreeDisplayMachine<String> display = new BinaryTreeDisplayMachine1<>(
                subtree);

        display.generateToFile("TreeBase.txt");
    }

    @Test
    public void testUserDefinedTreeSmall() {
        BinaryTree<String> subtree = new BinaryTree1<>();
        BinaryTree<String> left = subtree.newInstance();
        BinaryTree<String> right = subtree.newInstance();
        left.assemble("LEFT", subtree.newInstance(), subtree.newInstance());
        right.assemble("RIGHT", subtree.newInstance(), subtree.newInstance());
        subtree.assemble("ROOT", left, right);

        BinaryTreeDisplayMachine<String> display = new BinaryTreeDisplayMachine1<>(
                subtree);

        display.generateToFile("TreeSmall.txt");
    }
}
