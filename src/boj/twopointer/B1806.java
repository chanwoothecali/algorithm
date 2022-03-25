package boj.twopointer;

import boj.FastReader;

import java.util.StringTokenizer;

public class B1806 {

    private final FastReader scan = new FastReader();

    // 10 ~ 100,000
    private int N;
    // 1 ~ 100,000,000
    private int S;
    // 1 ~ 10,000 자연수
    private int[] numbers;

    private void main() {
        input();
        solve();
    }

    private void input() {
        StringTokenizer st = scan.spaceToken();
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        numbers = new int[N];

        st = scan.spaceToken();
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
    }

    private void solve() {
        int R = -1, sum = 0, ans = N + 1;
        for (int L = 0; L < N; L++) {
            if (L != 0) sum -= numbers[L - 1];

            while (R + 1 < N && sum < S) {
                sum += numbers[++R];
            }

            if (sum >= S) {
                ans = Math.min(ans, R - L + 1);
            }
        }

        if (ans > N) {
            System.out.println(0);
        } else {
            System.out.println(ans);
        }

    }

    public static void main(String[] args) {
        B1806 main = new B1806();
        main.main();
    }
}
