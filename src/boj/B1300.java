package boj;

public class B1300 {

    private final FastReader scan = new FastReader();

    // 1 ~ 10만
    private int N;
    // 1 ~ Math(10^9, N^2)
    private int k;

    private int[] B;

    public void main() {
        input();
        solve();

    }

    private void input() {
        N = scan.nextInt();
        k = scan.nextInt();
        B = new int[N*N + 1];
    }

    private void solve() {
        int left = 1, right = N*N;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (determine(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
                result = mid;
            }
        }

        System.out.println(result);
    }

    private boolean determine(int number) {
        int sum = 0;
        for (int i = 1; i <= N ; i++) {
            for (int j = 1; j <= N; j++) {
                if (i * j <= number) {
                    sum++;
                }
            }
        }
        return sum <= k;
    }

    public static void main(String[] args) {
        B1300 main = new B1300();
        main.main();
    }
}
