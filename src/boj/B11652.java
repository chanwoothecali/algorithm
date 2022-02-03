package boj;

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
        long maxValue = numbers[0];
        for (int i = 1; i < N; i++) {
            if (numbers[i - 1] == numbers[i]) {
                currCount++;
            } else {
                currCount = 1;
            }
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
