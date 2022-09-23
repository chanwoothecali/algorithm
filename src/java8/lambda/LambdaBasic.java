package java8.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaBasic {

    /**
     * 함수형 인터페이스와 람다 기본 표현식
     */
    public void lambdaBasic() {
        // JAVA 8 이전에 쓰던 익명 내부 클래스
        RunSomething runSomething1 = new RunSomething() {
            @Override
            public void doIt() {
                System.out.println("blah blah");
            }
        };

        // 람다로 리팩토링
        RunSomething runSomething2 = () -> System.out.println("blah blah");

        // 한 줄일 경우에만 위처럼 리팩토링 가능
        RunSomething runSomething3 = () -> {
            System.out.println("hello");
            System.out.println("hello");
        };

        // 순수 함수 익명 내부 클래스
        PureFunction pureFunction1 = new PureFunction() {
            @Override
            public int doIt(int number) {
                return number + 10;
            }
        };

        PureFunction pureFunction2 = number -> number + 10;

        // 순수 함수 익명 내부 클래스
        PureFunction pureFunction3 = new PureFunction() {
            int baseNumber = 10;

            @Override
            public int doIt(int number) {
                return number + baseNumber;
            }
        };

        // 이건 람다식 변경 불가
        PureFunction pureFunction4 = new PureFunction() {
            int baseNumber = 10;

            @Override
            public int doIt(int number) {
                return number + baseNumber;
            }
        };

        // 이렇게 직접 클래스를 작성하여 구현하는 방법이 있기도 하지만 (어떤 구현인지는 해당 클래스에서 확인)
        Plus10 plus10_1 = new Plus10();
        System.out.println(plus10_1.apply(1));

        // 굳이 클래스를 구현하지 않고 람다로 구현하는 방법도 있다.
        Function<Integer, Integer> plus10_2 = i -> i + 10;
        System.out.println(plus10_2.apply(1));

        // 함수가 함수를 매개변수로 받아서 사용할 수도 있다.
        Function<Integer, Integer> plus10_3 = i -> i + 10;
        Function<Integer, Integer> multiply_1 = i -> i * 2;
        Function<Integer, Integer> plus10ThenMultiply2 = multiply_1.compose(plus10_3); // compose -> 매개변수를 먼저 수행 후에 본 함수를 수행한다는 뜻
        System.out.println(plus10ThenMultiply2.apply(10)); // 40 -> (10 + 10) * 2
        Function<Integer, Integer> multiply2ThenPlus10 = multiply_1.andThen(plus10_3); // andThen -> 본 함수를 먼저 수행 후 매개변수에 쓰인 함수를 수행
        System.out.println(multiply2ThenPlus10.apply(10)); // 30 -> 10 * 2 + 10

        // 람다의 기본 표현식은 (인자 리스트) -> {바디}
        Supplier<Integer> getOne = () -> 1;
        BinaryOperator<Integer> sum = (a, b) -> a + b;
    }

    /**
     * 지역 변수와 섀도잉
     */
    // 전역 변수
    int globalVar = 10;
    private void localVariableAndShadowingExample() {

        // 로컬 클래스, 익명 클래스, 람다는 지역 변수에 접근할 수는 있지만 해당 변수가 final이어야 한다. // 자바8 이전에는 final에만 접근 가능
        // final이 안붙고 선언될 수는 있지만 익명 클래스에서 사용하려면 사용 이후엔 변경이 없어야 함 -> 사실상 final
        // -> final은 아니지만 final처럼 이후에 변경이 없는 것을 effective final이라고 함
        // 다만, 람다는 로컬 클래스, 익명 클래스와 다르게 쉐도잉이 일어나지 않는다.
        // 쉐도잉이 무엇이냐? 아래 예제 참조

        // 로컬 변수
        int localVar = 10; // effectiveFinal
        int shadowingVar = 100;

        // 로컬 클래스
        class LocalClass {
            int shadowingVar = 200;

            void doIt() {
                System.out.println(globalVar);
                System.out.println(localVar);
                System.out.println(shadowingVar); // 200
            }
        }

        // 익명 클래스
        Consumer<Integer> anonymousClass = new Consumer<Integer>() {

            @Override
            public void accept(Integer shadowingVar) {
                System.out.println(globalVar);
                System.out.println(localVar);
                System.out.println(shadowingVar); // 매개변수 출력
            }
        };

        // 람다
        RunSomething lambda = () -> {
            System.out.println(globalVar);
            System.out.println(localVar);
            System.out.println(shadowingVar);
        };

        // 불가능
//        RunSomething lambdaShadowing = (shadowingVar) -> {
//            System.out.println(globalVar);
//            System.out.println(localVar);
//            System.out.println(shadowingVar);
//        };

        /**
         * 람다에서 섀도잉이 일어나지 않는 이유는 람다는 같은 스콥을 유지하기 때문
         * 내부클래스와 익명클래스는 새로운 스콥을 만들지만, 람다는 람다를 감싸고 있는 스콥과 같다.
         * 한 스콥 내에 동일한 변수명을 가진 변수를 생성하지 못한다.
         */

        globalVar++; // 전역변수는 final처럼 안써도 됨
    }

    /**
     * 메소드 레퍼런스 (함수 참조)
     */
    public void methodReferenceExample() {
        
        // static 메소드 참조
        Consumer<String> staticMethodReference = MethodReferenceClass::hi;

        // 인스턴스 메소드 참조
        Consumer<String> instanceMethodReference1 = new MethodReferenceClass()::hello;

        // 특정 객체 인스턴스 메소드 참조
        MethodReferenceClass methodReferenceClass = new MethodReferenceClass();
        Consumer<String> instanceMethodReference2 = methodReferenceClass::hello;

        // 생성자 참조
        Supplier<MethodReferenceClass> newMethodReferenceClass = MethodReferenceClass::new;
        MethodReferenceClass referenceClass = newMethodReferenceClass.get();

        // 파라미터 생성자 참조
        Function<String, MethodReferenceClass> parameterConstructor = MethodReferenceClass::new;
        // 일반 생성자 참조와 모양이 비슷하기 때문에 추후 로직을 확인해야함
        MethodReferenceClass apply = parameterConstructor.apply("chanwoo");
        System.out.println(apply.getName()); // chanwoo
    }

    public void lambdaAndMethodReferenceExample() {
        String[] names = {"chanwoo", "jiwon", "seungjae"};
        // 익명 클래스
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        // 람다
        Arrays.sort(names, (o1, o2) -> o1.compareTo(o2));

        // 메소드 참조
        Arrays.sort(names, String::compareTo);
    }

    public static void main(String[] args) {

    }
}
