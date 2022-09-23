package java8.changedInterface;

public class ChildInterfaceImpl implements ChildInterface, AnotherInterface {

    @Override
    public void printUppercaseName() {

    }

    @Override
    public void conflictMethod() {
        // 재정의
    }

    @Override
    public void printName() {

    }

    @Override
    public String getName() {
        return null;
    }
}
