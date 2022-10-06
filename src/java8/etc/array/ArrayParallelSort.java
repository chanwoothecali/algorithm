package java8.etc.array;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class ArrayParallelSort {

    public static void main(String[] args) {
        int size = 1500;
        int[] numbers = new int[size];
        Random random = new Random();

        /**
         * 일반 sort
         * Dual-pivot Quick sort
         */
        IntStream.range(0, size).forEach(i -> numbers[i] = random.nextInt());
        long start = System.nanoTime();
        Arrays.sort(numbers);
        System.out.println("serial sorting: " + (System.nanoTime() - start));

        /**
         * parallel sort
         * 배열을 둘로 계속 나눈 후 합치면서 정렬
         */
        IntStream.range(0, size).forEach(i -> numbers[i] = random.nextInt());
        start = System.nanoTime();
        Arrays.parallelSort(numbers);
        System.out.println("parallel sorting: " + (System.nanoTime() - start));

        /**
         * 알고리즘 효율성은 둘 다 같다
         * 시간 O(nlogN) 공간 O(n)
         * 근데 매번 실행해봐도 parallelSort가 더 빠르긴 함
         */
    }
}
