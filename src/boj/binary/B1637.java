package boj.binary;

import boj.FastReader;

import java.util.StringTokenizer;

public class B1637 {

    private final FastReader scan = new FastReader();
    // 1 ~ 200000
    private int N;
    private int[][] info;

    public void main() {
        input();
        solve();
    }

    private void input() {
        N = scan.nextInt();
        info = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = scan.spaceToken();
            // 1 ~ Integer.MAX_VALUE;
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
            info[i][2] = Integer.parseInt(st.nextToken());
        }
    }

    private void solve() {
        long left = 1, right = Integer.MAX_VALUE;

        long ans = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (determine(mid)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }

        long numOfAns = 0;

        if (ans == 0) {
            System.out.println("NOTHING");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (info[i][0] > ans || info[i][1] < ans) continue;

            if ((ans - info[i][0]) % info[i][2] == 0) {
                numOfAns += 1;
            }
        }

        System.out.println(ans + " " + numOfAns);
    }

    private boolean determine(long mid) {
        // 이거 int로 했다가 틀렸었음
        long sum = 0;

        for (int i = 0; i < N; i++) {
            if (info[i][0] > mid) continue;

            if (info[i][1] < mid) {
                sum += (info[i][1] - info[i][0]) / info[i][2] + 1;
            } else {
                sum += (mid - info[i][0]) / info[i][2] + 1;
            }
        }

        return sum%2 == 1;
    }

    public static void main(String[] args) {
        B1637 main = new B1637();
        main.main();
    }
}
