package java8.changedInterface;

public interface ChildInterface extends ParentInterface {
    /**
     * 자식 인터페이스에서 부모 인터페이스에서 제공하는 default 메소드를 다시 구현하고 싶다?
     * -> 그러면 다시 추상 메소드로 선언하면 된다.
     * 다만 해당 인터페이스를 구현하는 객체들은 이 메소드를 재정의 해야함.
     * default 메소드로 새로 구현해줘도 된다.
     */
    void printUppercaseName();

    /**
     * ChildInterfaceImpl은 ChildInterface와 AnotherInterface를 둘 다 구현하는 클래스다.
     * 이때 ChildInterface와 AnotherInterface 둘 다 동일한 이름의 default 함수가 있다면 어떻게 될까?
     * -> 오류 나기때문에 ChildInterface에서 재정의를 해주어야 한다.
     */
    default void conflictMethod() {

    }
}
