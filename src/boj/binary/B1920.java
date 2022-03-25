package boj.binary;

import boj.FastReader;

import java.util.Arrays;

public class B1920 {
    private FastReader scan = new FastReader();
    private int N, M;
    private int[] A, B;

    private void input() {
        N = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
        }
        M = scan.nextInt();
        B = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            B[i] = scan.nextInt();
        }
    }

    private void solve() {
        Arrays.sort(A, 1, N + 1);

        for (int i = 1; i <= N; i++) {
            System.out.println(isExist(B[i]));
        }
    }

    private int isExist(int a) {
        int left = 1, right = N;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[mid] == a) {
                return 1;
            } else if (A[mid] > a) {
                right = mid - 1;
            } else if (A[mid] < a) {
                left = mid + 1;
            }
        }
        return 0;
    }

    public void main() {
        input();
        solve();
    }

    public static void main(String[] args) {
        B1920 b1920 = new B1920();
        b1920.main();
    }
}
