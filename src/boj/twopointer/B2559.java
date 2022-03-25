package boj.twopointer;

import boj.FastReader;

import java.util.StringTokenizer;

public class B2559 {
    private final FastReader scan = new FastReader();
    // -100 ~ 100
    private int[] temperatures;
    // 2 ~ 100,000
    private int N;
    // 1 ~ N
    private int K;

    public void main() {
        input();
        solve();
    }

    private void input() {
        StringTokenizer st = scan.spaceToken();
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = scan.spaceToken();
        temperatures = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            temperatures[i] = Integer.parseInt(st.nextToken());
        }
    }

    private void solve() {
        int L = 0, sum = 0, ans = Integer.MIN_VALUE;
        for (int R = 1; R <= N; R++) {
            sum += temperatures[R];

            if (R >= K) {
                sum -= temperatures[L++];
                ans = Math.max(ans, sum);
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        B2559 main = new B2559();
        main.main();
    }
}
