package java8.changedInterface;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;

public class DefaultMethodAPIExample {

    /**
     * Iterable
     */
    public static void iterableExample() {
        List<String> names = new ArrayList<>();
        names.add("chanwoo");
        names.add("jiwon");
        names.add("seungjae");
        names.add("sangyong");

        // 순회
        names.forEach(System.out::println);
        System.out.println("==============================");
        
        // 반으로 스플릿 후 출력
        Spliterator<String> spliterator = names.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();
        while (spliterator.tryAdvance(System.out::println));
        System.out.println("==============================");
        while (spliterator1.tryAdvance(System.out::println));
    }

    /**
     * Collection
     * 참고로 Collection 내부에 자바8 핵심 기술인 stream이 존재
     * Collection 타입 객체들은 전부 stream 사용 가능
     */
    public static void collectionExample() {
        List<String> names = new ArrayList<>();
        names.add("chanwoo");
        names.add("jiwon");
        names.add("seungjae");
        names.add("sangyong");

        // stream
        long count = names.stream().map(String::toUpperCase)
                .filter(s -> s.startsWith("S"))
                .count();
        System.out.println(count); // 2

        // removeIf
        names.removeIf(s -> s.startsWith("s")); // s 시작 둘 삭제
        names.forEach(System.out::println);
    }

    /**
     * Comparator
     */
    public static void comparatorExample() {
        List<String> names = new ArrayList<>();

        names.add("chanwoo");
        names.add("jiwon");
        names.add("seungjae");
        names.add("sangyong");

        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        names.sort(compareToIgnoreCase.reversed());
        names.forEach(System.out::println);
    }

    public static void main(String[] args) {
//        iterableExample();
//        collectionExample();
        comparatorExample();
    }
}
