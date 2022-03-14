package boj;

import java.util.StringTokenizer;

public class B2003 {

    private FastReader scan = new FastReader();
    // 1 ~ 10,000
    private int N;
    // 1 ~ 300,000,000
    private int M;
    // 1 ~ 30,000 자연수
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
        st = scan.spaceToken();
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
    }

    private void solve() {
        int R = 0, sum = 0, cnt = 0;
        for (int L = 1; L <= N; L++) {
            sum -= A[L - 1];

            while (R < N && sum < M) {
                sum += A[++R];
            }

            if (sum == M) cnt++;
        }

        System.out.println(cnt);
    }

    public static void main(String[] args) {
        B2003 main = new B2003();
        main.main();
    }
}
