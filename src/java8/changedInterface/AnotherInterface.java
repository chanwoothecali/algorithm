package java8.changedInterface;

public interface AnotherInterface {

    default void conflictMethod() {

    }

    void printName();
}
