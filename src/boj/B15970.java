package boj;

import java.util.ArrayList;
import java.util.Collections;

public class B15970 {

    static int N;
    static final FastReader scan = new FastReader();
    static ArrayList<Integer>[] a;

    static void input() {
        N = scan.nextInt();
        a = new ArrayList[N + 1];
        // 문제를 잘 읽어보자...
        // 0부터 N-1까지로 했다가 안되길래 대체 왜인가 했더니
        // 문제 자체에 N은 2부터 시작한다는 조건이 있었음
        for (int color = 1; color <= N; color++) {
            a[color] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            a[y].add(x);
        }
    }

    static void solve() {
        int ans = 0;

        for (int color = 1; color <= N; color++) {
            if (a[color].isEmpty()) continue;
            Collections.sort(a[color]);
            for (int i = 0; i < a[color].size(); i++) {
                int leftArrow = toLeft(color, i);
                int rightArrow = toRight(color, i);
                ans += Math.min(leftArrow, rightArrow);
            }
        }

        System.out.println(ans);
    }

    static int toLeft(int color, int idx) {
        if (idx == 0) {
            return Integer.MAX_VALUE;
        }else {
            return a[color].get(idx) - a[color].get(idx - 1);
        }
    }

    static int toRight(int color, int idx) {
        if (idx == a[color].size() - 1) {
            return Integer.MAX_VALUE;
        }else {
            return a[color].get(idx + 1) - a[color].get(idx);
        }
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
