import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.stopwatch.Stopwatch;
import components.stopwatch.Stopwatch1;

public class BinaryTreeDisplayMachineTest {
    public static int current;
    public SimpleWriter out;

    @Before
    public void setUp() {
        current++;
        this.out = new SimpleWriter1L("data/out"
                + (((int) Math.pow(2, current)) - 1) + ".txt");
        System.out.println(current);
    }

    @After
    public void tearDown() {
        this.out.close();
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

        this.out.println("Running time of const : " + sw.elapsed());

        sw.clear();

        sw.start();
        dis1.generateToFile("tmp.txt");
        sw.stop();

        this.out.println("Running time of display : " + sw.elapsed());
    }
}
