package boj.twopointer;

import boj.FastReader;

import java.util.Arrays;
import java.util.StringTokenizer;

public class B13144 {

    private final FastReader scan = new FastReader();
    // 1 ~ 100,000
    private int N;
    // 1 ~ 100,000
    private int[] numbers;

    public void main() {
        input();
        solve();
    }

    private void input() {
        N = scan.nextInt();
        numbers = new int[N + 1];

        StringTokenizer st = scan.spaceToken();
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
    }

    private void solve() {
        int[] count = new int[100001];
        long sum = 0;
        int R = 1;
        for (int L = 1; L <= N; L++) {
            while (R <= N && count[numbers[R]] != 1) {
                count[numbers[R]] = 1;
                R++;
            }

            count[numbers[L]] = 0;
            sum += R - L;
        }

        System.out.println(sum);
    }

    public static void main(String[] args) {
        B13144 main = new B13144();
        main.main();
    }
}
