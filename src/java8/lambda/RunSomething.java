package java8.lambda;

// java에서 제공해주는 어노테이션
// 해당 어노테이션을 붙여야 함수형 인터페이스가 되는 건 아니고 그냥 컴파일러가 추상 메소드 2개 이상인지 체크하는 기능
@FunctionalInterface
public interface RunSomething {

    // 인터페이스에서는 abstract 생략 가능 // 이미 추상 메소드
    /*abstract*/ void doIt();

    // 함수형 인터페이스는 추상메소드를 단 하나만 가지고 있는 메소드
    // void anotherDoIt();
    // 위처럼 여타 다른 메소드가 추가되는 순간 함수형 인터페이스가 아니게 된다.

    // 자바8부터는 인터페이스에 static 메소드와 default 메소드를 추가할 수 있다.
    static void printName() {
        System.out.println("찬우");
    }

    default void printHello() {
        System.out.println("Hello");
    }

    // 그렇다면 추상메소드 이외 static 메소드나 default 메소드가 추가된 인터페이스는?
    // -> 그것도 함수형 인터페이스다!
    // SAM (Single Abstract Method) 인터페이스 -> 추상메소드 단 한 개의 인터페이스
}
