package boj;

import java.util.Arrays;

public class B2512 {

    private final FastReader scan = new FastReader();

    // 3 <= N <= 10,000
    private int N;
    // 1 <= budget[i] <= 100,000
    private int[] budget;
    // N <= M <= 10억
    private int M;

    private void input() {
        N = scan.nextInt();
        budget = new int[N];
        for (int i = 0; i < N; i++) {
            budget[i] = scan.nextInt();
        }
        M = scan.nextInt();
    }

    private void solve() {
        Arrays.sort(budget);

        int left = 0, right = budget[N - 1];
        int ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (isLowerBudget(mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }

    private boolean isLowerBudget(int avgBudget) {
        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += Math.min(budget[i], avgBudget);
        }

        return sum <= M;
    }

    public void main() {
        input();
        solve();
    }

    public static void main(String[] args) {
        B2512 main = new B2512();
        main.main();
    }
}
