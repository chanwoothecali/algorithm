package boj.twopointer;

import boj.FastReader;

import java.util.Arrays;
import java.util.StringTokenizer;

public class B2230 {

    private final FastReader scan = new FastReader();
    // 1 ~ 100,000 정수
    private int N;
    // 0 ~ 20억 정수
    private int M;
    // A[i] -10억 ~ 10억 정수
    private int[] A;

    public void main() {
        input();
        solve();
    }

    private void input() {
        StringTokenizer st = scan.spaceToken();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
    }

    private void solve() {
        Arrays.sort(A, 1, N + 1);

        int R = 1, gap = Integer.MAX_VALUE;
        for (int L = 1; L <= N; L++) {

            while (R + 1 <= N && A[R] - A[L] < M) R++;

            if (A[R] - A[L] < M) continue;
            gap = Math.min(gap, A[R] - A[L]);
        }

        System.out.println(gap);
    }

    public static void main(String[] args) {
        B2230 main = new B2230();
        main.main();
    }
}
