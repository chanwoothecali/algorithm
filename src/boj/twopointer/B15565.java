package boj.twopointer;

import boj.FastReader;

import java.util.StringTokenizer;

public class B15565 {
    private final FastReader scan = new FastReader();
    // 1 ~ 1000000
    private int N;
    // 1 ~ N
    private int K;
    // 1 or 2
    private int[] dolls;

    public void main() {
        input();
        solve();
    }

    private void input() {
        StringTokenizer st = scan.spaceToken();
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dolls = new int[N + 1];
        st = scan.spaceToken();
        for (int i = 1; i <= N; i++) {
            dolls[i] = Integer.parseInt(st.nextToken());
        }
    }

    private void solve() {
        int R = 1, totalCnt = 1, lionCnt = 0, ans = N + 1;
        for (int L = 1; L <= N; L++) {
            totalCnt--;
            if (dolls[L - 1] == 1) lionCnt--;

            while (dolls[L] == 1 && lionCnt < K && R < N) {
                R++;
                totalCnt++;
                if (dolls[R] == 1) lionCnt++;
            }

            if (lionCnt == K) {
                ans = Math.min(ans, totalCnt);
            }
        }

        if (ans > N) {
            System.out.println(-1);
        } else {
            System.out.println(totalCnt);
        }
    }

    public static void main(String[] args) {
        B15565 main = new B15565();
        main.main();
    }
}
