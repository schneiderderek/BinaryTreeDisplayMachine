/**
 * Customized JUnit test fixture for {@code BTDM1}.
 */
public class BinaryTreeDisplayMachine1Test extends BinaryTreeDisplayMachineTest {

    @Override
    protected final BinaryTreeDisplayMachine<String> constructor() {
        return new BinaryTreeDisplayMachine1<String>();
    }
}
