package boj.graph;

import boj.FastReader;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1697 {

    private final FastReader scan = new FastReader();

    // 0 ~ 100,000
    private int N, K;

    private int[] seconds = new int[100001];

    public void main() {
        input();
        solve();
    }

    private void input() {
        StringTokenizer st = scan.spaceToken();
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }

    private void solve() {
        if (N == K) {
            System.out.println(0);
            return;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int i = 0; i < 3; i++) {
                int mx = move(x, i);
                if (isNotPossible(mx)) continue;
                queue.offer(mx);
                seconds[mx] = seconds[x] + 1;
            }
        }

        System.out.println(seconds[K]);
    }

    private int move(int x, int i) {
        switch (i) {
            case 0:
                return x - 1;
            case 1:
                return x + 1;
            case 2:
                return 2 * x;
            default:
                return 0;
        }
    }

    private boolean isNotPossible(int x) {
        if (x < 0) return true;

        if (x > 100000) return true;

        return seconds[x] != 0;
    }

    public static void main(String[] args) {
        B1697 main = new B1697();
        main.main();
    }
}
