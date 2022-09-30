package java8.optional;

import java8.OnlineClass;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Predicate;

public class OptionalBasic {

    /**
     * 옵셔널 기본
     */
    public static void optionalBasic() {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        /**
         * null 객체를 참조하려하면 NPE가 발생한다.
         * JAVA 8 이전에는 null체크를 강요하거나 Exception을 던진다.
         * JAVA 8 브터는 Optional을 리턴한다.
         */
        OnlineClass spring_boot = new OnlineClass(1, "spring boot", true);
//        Duration studyDuration = spring_boot.getProgress().getStudyDuration();
//        System.out.println("studyDuration = " + studyDuration);
        Progress progress = spring_boot.getProgress().orElseThrow(IllegalArgumentException::new);
        Duration studyDuration = progress.getStudyDuration();
        System.out.println("studyDuration = " + studyDuration);

        /**
         * Optional은 return 타입 외에 메소드의 매개변수, 맵의 키 타입, 인스턴스 필드 타입으로 쓰지말자.
         * 매개변수 -> 매개변수에 Optional을 쓰면 해당 Optional객체가 null인지도 체크해야 하고, Optional에서 꺼낼 때 객체가 null인지도 체크해야 하는 번거로움이 발생
         * 맵의 키 타입 -> 맵이라는 interface의 특징을 깨뜨리는 것, 맵은 키가 null일 수 없다는 것이 가장 큰 특징인데 Optional로 비어있을 수도 있다고 하는 것은 어불성설
         * 인스턴스 필드 타입 -> 그건 도메인의 설계 문제
         */

        /**
         * Optional에 Primitive 타입을 반환하는 방법도 있음
         */
        OptionalInt.of(10);

    }

    /**
     * Optional을 반환하는 함수에서 null을 반환하지 말자.
     * 이러면 이 함수를 쓰는 클라이언트 측에서 오류가 발생
     * 정말 반환할 게 없다면 아래와 같이 반환
     */
    public Optional<Progress> getProgress() {
//        return null;
        return Optional.empty();
    }

    /**
     * Collection, Map, Stream Array, Optional은 Optional로 감싸지 말 것
     * 이미 그 자체로 비어있는지를 판단할 수 있는 Container 성격의 인스턴스는 Optional로 감싸는 것이 두 번 감싸는 형태라 지양.
     */

    /**
     * Optional API
     */
    public static void optionalApi() {
        /**
         * Optional 객체 만들기
         */
        Optional<OnlineClass> optionalOnlineClass1 = Optional.of(new OnlineClass(1, "spring boot", true));
        Optional<OnlineClass> optionalOnlineClass2 = Optional.ofNullable(new OnlineClass(1, "spring boot", true));
        Optional<Object> empty = Optional.empty();


        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        Optional<OnlineClass> optionalOnlineClass = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();
        /**
         * Optional 객체 값이 있는지 확인
        */
        boolean present = optionalOnlineClass.isPresent();
        boolean onlineClassEmpty = optionalOnlineClass.isEmpty();

        /**
         * Optional 객체 단순 가져오기
         * 값이 없을 경우 NoSuchElementException (RuntimeException) 발생
         * -> 가급적 get 사용 대신에 다른 API를 사용하라.
         */
        OnlineClass onlineClass = optionalOnlineClass.get();

        /**
         * Optional 값이 있으면 가져오고 ~~를 해라, 없으면 아무동작도 일어나지 않는다.
         */
        optionalOnlineClass.ifPresent(oc -> System.out.println(oc.getTitle()));

        /**
         * Optional 값이 있으면 가져오고, 없는 경우에 ~~를 리턴하라
         * orElse와 orElseGet의 차이
         * orElse는 값이 있더라도 else에 있는 연산이 실행된다. orElseGet은 값이 있으면 else 연산을 실행하지 않음
         *
         * orElse는 이미 만들어진 인스턴스를 줄 때 사용하고, orElseGet은 동적으로 인스턴스를 만들어서 반환할 때 쓴다.
         */
        OnlineClass orElse = optionalOnlineClass.orElse(createNewClass());
        OnlineClass orElseGet = optionalOnlineClass.orElseGet(OptionalBasic::createNewClass);
        System.out.println(orElseGet.getTitle());

        /**
         * Optional 값이 있으면 가져오고, 없다면 예외를 던져라
         */
        OnlineClass orElseThrow = optionalOnlineClass.orElseThrow(IllegalStateException::new);

        /**
         * Optional에 들어있는 값 걸러내기
         * 값이 없다면 아무 동작도 수행하지 않는다.
         */
        Optional<OnlineClass> filter = optionalOnlineClass.filter(Predicate.not(OnlineClass::isClosed));

        /**
         * Optional에 있는 값 변환하기
         */
        Optional<Integer> integer = optionalOnlineClass.map(OnlineClass::getId);
        // 근데 Optional이 Optional을 반환하는 경우는?
        Optional<Optional<Progress>> progress = optionalOnlineClass.map(OnlineClass::getProgress);
        // 이 경우는 map 대신 flatMap을 쓰면 된다.
        Optional<Progress> optionalProgress = optionalOnlineClass.flatMap(OnlineClass::getProgress);
        /**
         * Stream에서 쓰이는 flatMap과는 다르다
         * Stream.flatMap -> input은 하나지만 output이 여러 개일 수 있음
         * Optional.flatMap -> input이 하나면 output이 하나다.
         */
    }

    public static OnlineClass createNewClass() {
        System.out.println("create new class");
        return new OnlineClass(10, "test class", false);
    }

    public static void main(String[] args) {
//        optionalBasic();
        optionalApi();
    }
}
