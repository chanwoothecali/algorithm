package java8.changedInterface;

public interface ParentInterface {

    void printName();

    String getName();

    // 인터페이스 메소드를 구현한 클래스들이 있는 상황에서 메소드를 더 추가하면 구현 클래스 전부에서 에러가 발생한다.
    // void secondMethod(); // 구현 클래스에서 Override 안해줘서 오류 발생
    // 이런 경우에 쓸 수 있는 것이 default method
    // 하위 구현 클래스에서 해당 메소드를 사용 가능하다.
    /**
     * 하지만 이러한 default 메소드는 구현체가 모르게 생성된 것이기 때문에 구현체에서 사용시 오류가 발생할 확률이 있다.
     * 오류가 발생하진 않더라도 구현체에서는 생각처럼 작동하지 않을 가능성이 있음.
     * 그렇기 때문에 @implspec 자바독 태그를 이용해 문서화를 하거나, 구현체에서 다시 Override하는 방법이 필요하다.
     * @implSpec 이 구현체는 getName()으로 가져온 문자열을 대문자로 바꿔서 출력한다.
     */
    default void printUppercaseName() {
        System.out.println(getName().toUpperCase());
    }

    // Default method 'toString' overrides a member of 'java.lang.Object'
    // Object 메소드는 default 메소드로 구현할 수 없다.
//    default String toString() {
//
//    }

    /**
     * 해당 타입 관련 헬퍼 또는 유틸리티 메소드를 제공할 때 인터페이스에 스태틱 메소드를 제공할 수 있다.
     */
    static void printAnything() {
        System.out.println("blah blah");
    }
}