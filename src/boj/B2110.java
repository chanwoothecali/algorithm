package boj;

import java.util.Arrays;

public class B2110 {
    private final FastReader scan = new FastReader();
    // 2 <= N <= 200,000
    private int N;
    // 2 <= C <= N
    private int C;
    // 0 <= x[i] <= 10억
    private int[] X;
    private int[] distances;

    private void input() {
        N = scan.nextInt();
        C = scan.nextInt();
        X = new int[N];
        for (int i = 0; i < N; i++) {
            X[i] = scan.nextInt();
        }
    }

    private void solve() {
        Arrays.sort(X);

        int left = X[0], right = X[N - 1];
        int ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (determine(mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            System.out.println("mid = " + mid);
        }

        System.out.println(ans);
    }

    private boolean determine(int mid) {
        int sum = 0;

        int currX = X[0];
        int i = 0;
        while (i < N) {
            System.out.println(currX);
            for (int j = i; j < N; j++) {
                int nextX = X[j];
                if (nextX - currX >= mid) {
                    sum += 1;
                    currX = nextX;
                    i = j;
                    break;
                } else if (j == N - 1) {
                    i = N;
                }
            }
            System.out.println("test2");
        }
        System.out.println("sum = " + sum);

        return sum <= C;
    }

    public void main() {
        input();
        solve();
    }

    public static void main(String[] args) {
        B2110 b2110 = new B2110();
        b2110.main();
    }
}
