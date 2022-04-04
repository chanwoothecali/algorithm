package boj.twopointer;

import boj.FastReader;

import java.util.Arrays;
import java.util.StringTokenizer;

public class B1253 {

    private final FastReader scan = new FastReader();
    // 1 ~ 2000
    private int N;
    // -10억 ~ 10억
    private int[] A;

    public void main() {
        input();
        solve();
    }

    private void input() {
        N = scan.nextInt();
        A = new int[N + 1];

        StringTokenizer st = scan.spaceToken();
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
    }

    private void solve() {
        Arrays.sort(A, 1, N + 1);

        int ans = 0;
        for (int index = 1; index <= N; index++) {
            if (isSumOfOtherNum(index)) ans++;
        }

        System.out.println(ans);
    }

    private boolean isSumOfOtherNum(int targetIndex) {
        int L = 1, R = N, target = A[targetIndex];
        while (L < R) {
            if (L == targetIndex) {
                L++;
                continue;
            }

            if (R == targetIndex) {
                R--;
                continue;
            }

            if (A[L] + A[R] == target) {
                return true;
            } else if (A[L] + A[R] < target) {
                L++;
            } else {
                R--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        B1253 main = new B1253();
        main.main();
    }
}
