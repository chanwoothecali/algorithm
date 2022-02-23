package boj;

import java.util.Arrays;

public class B1654 {

    private final FastReader scan = new FastReader();
    // 1 <= K <= 10,000
    private int K;
    // 1 <= N <= 1,000,000
    private int N;
    private int[] lines;

    private void input() {
        K = scan.nextInt();
        N = scan.nextInt();
        lines = new int[K];
        for (int i = 0; i < K; i++) {
            lines[i] = scan.nextInt();
        }
    }

    private void solve() {
        Arrays.sort(lines);

        // 이 단위가 int면 틀림
        long left = 1, right = lines[K - 1];
        long ans = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (divideLines(mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }

    private boolean divideLines(long cutHeight) {
        long numberOfCuttingLines = 0;
        for (int i = 0; i < K; i++) {
            numberOfCuttingLines += lines[i] / cutHeight;
        }
        return numberOfCuttingLines >= N;
    }

    public void main() {
        input();
        solve();
    }

    public static void main(String[] args) {
        B1654 b1654 = new B1654();
        b1654.main();
    }
}
