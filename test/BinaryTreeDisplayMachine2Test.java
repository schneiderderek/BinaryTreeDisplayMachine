/**
 * Customized JUnit test fixture for {@code BTDM2}.
 */
public class BinaryTreeDisplayMachine2Test extends BinaryTreeDisplayMachineTest {

    @Override
    protected final BinaryTreeDisplayMachine<String> constructor() {
        return new BinaryTreeDisplayMachine2<String>();
    }
}
