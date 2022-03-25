package boj.sort;

import boj.FastReader;

import java.util.Arrays;

public class B11652 {

    static FastReader scan = new FastReader();
    static int N;
    static long[] numbers;

    static void input() {
        N = scan.nextInt();
        numbers = new long[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = scan.nextLong();
        }
    }

    static void solve() {
        Arrays.sort(numbers);
        int currCount = 1;
        int maxCount = 1;
        // maxValue 0으로 시작시 같은 번호로만 이루어진 카드의 최대값 판별 불가
        long maxValue = numbers[0];
        for (int i = 1; i < N; i++) {
            if (numbers[i - 1] == numbers[i]) {
                currCount++;
            } else {
                currCount = 1;
            }
            // else구문에 아래 if문을 넣을시 첫value가 maxValue인 경우 캐치 불가
            if (currCount > maxCount) {
                maxCount = currCount;
                maxValue = numbers[i - 1];
            }
        }
        System.out.println(maxValue);
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
