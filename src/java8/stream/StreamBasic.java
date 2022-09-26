package java8.stream;

import java8.OnlineClass;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamBasic {

    /**
     * 스트림 기본 내용
     */
    public static void streamBasic() {
        // 기본적으로 스트림은 저장소(컬렉션)가 아니다.
        // 스트림은 컬렉션을 만들어주는 컨베이어 벨트 같은 것
        List<String> names = new ArrayList<>();

        names.add("chanwoo");
        names.add("jiwon");
        names.add("seungjae");
        names.add("sangyong");

        // 스트림은 Functional하다.
        // -> 그뜻은 스트림은 원 컬렉션의 내용을 유지한다는 것
        List<String> streamNames = names.stream().map(String::toUpperCase).collect(Collectors.toList());
        names.forEach(System.out::println);
        System.out.println("===============");
        streamNames.forEach(System.out::println);
    }


    /**
     * 스트림 파이프라인
     */
    public static void streamPipeline() {
        /**
         * 스트림 메소드는 기본적으로 2가지로 나뉜다.
         * 중개형 오퍼레이션 (intermediate operation)
         * 종료 오퍼레이션 (terminal operation)
         * 중개형 오퍼레이션은 스트림을 리턴하고, 종료 오퍼레이션은 다른 타입을 리턴한다.
         */
        // 중개형 오퍼레이션은 LAZY하다.
        List<String> names = new ArrayList<>();

        names.add("chanwoo");
        names.add("jiwon");
        names.add("seungjae");
        names.add("sangyong");

        // 아래 내용은 출력되지 않는다. 중개형 오퍼레이션은 LAZY하기 때문.
        // 무슨뜻이냐 하면, 스트림은 종료 오퍼레이션이 없으면 아무 의미가 없다는 뜻
        names.stream().map(s -> {
            System.out.println(s);
            return s.toUpperCase();
        });
        System.out.println("===========");
        // 아래는 종료 오퍼레이션으로 스트림을 종료 시켰기때문에 출력이 된다.
        List<String> collect = names.stream().map(s -> {
            System.out.println(s);
            return s.toUpperCase();
        }).collect(Collectors.toList());
        System.out.println("===========");
        collect.forEach(System.out::println);
    }

    /**
     * 스트림 병렬 처리
     */
    public static void parallelStream() {
        /**
         * 스트림을 쓰는 이유는 뭘까?
         */
        List<String> names = new ArrayList<>();

        names.add("chanwoo");
        names.add("jiwon");
        names.add("seungjae");
        names.add("sangyong");

        // 아래 두 코드는 스트림을 썼냐 안썼냐의 차이 뿐이지 결국엔 똑같다.
        names.stream().map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);
        for (String name : names) {
            System.out.println(name.toUpperCase());
        }
        // 똑같이 작동하는 코드가 있는데 왜 스트림을 쓰는가?
        /**
         * 스트림을 사용하는 이유
         * 1. 복잡한 코드를 가독성 있고 간단하게 구현이 가능
         * ex) 위 예제 같은 건 쉬우니까 스트림 안써도 가독성 있게 처리가 가능하지만 저기에 좀 더 복잡한 요구사항이 추가되는 순간 코드가 너저분해진다.
         * 2. 병렬 처리가 가능
         */
        // 병렬 처리
        List<String> collect = names.parallelStream().map(s -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());
        // 근데 병렬처리를 한다고 다 빠른 것은 아니다. 오히려 느릴 수도 있음.
        // 웬만한 상황에서는 그냥 stream을 쓰는 것이 낫다.
    }

    /**
     * 스트림 기본 api 예제
     */
    public static void streamApi() {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", true));

        List<List<OnlineClass>> baekClasses = new ArrayList<>();
        baekClasses.add(springClasses);
        baekClasses.add(javaClasses);

        /**
         * filter
         */
        System.out.println("spring 으로 시작하는 수업");
        springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .forEach(oc -> System.out.println(oc.getTitle()));

        System.out.println("close 되지 않은 수업");
        springClasses.stream()
                .filter(Predicate.not(OnlineClass::isClosed))
                .forEach(oc -> System.out.println(oc.getTitle()));

        /**
         * map & flatMap
         */
        System.out.println("수업 이름만 모아서 스트림 만들기");
        springClasses.stream()
                .map(OnlineClass::getTitle)
                .forEach(System.out::println);

        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
        baekClasses.stream()
                .flatMap(Collection::stream)
                .map(OnlineClass::getId)
                .forEach(System.out::println);

        /**
         * generate & iterate
         */
        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");
        Stream.iterate(10, i -> i + 1) // i++은 안되네
                .skip(10)
                .limit(10)
                .forEach(System.out::println);

        /**
         * anyMatch
         * filter가 아닌 anyMatch로 구현한 이유?
         * -> filter는 끝까지 탐색, anyMatch는 중간에 일치하는 값이 있으면 탐색 종료
         */
        System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
        boolean test = javaClasses.stream()
                .anyMatch(oc -> oc.getTitle().contains("Test"));
        System.out.println("test = " + test);

        /**
         * collect
         */
        System.out.println("스프링 수업 중 spring이 들어가는 수업 제목만 모아서 리스트화");
        List<String> spring = springClasses.stream()
                .filter(oc -> oc.getTitle().contains("spring"))
                .map(OnlineClass::getTitle)
                .collect(Collectors.toList());
        spring.forEach(System.out::println);
    }

    public static void main(String[] args) {
//        streamBasic();
//        streamPipeline();
        streamApi();
    }
}
