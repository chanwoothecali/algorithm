package boj.bruteforce;

import boj.FastReader;

import java.util.*;

public class B1174 {

    private FastReader scan = new FastReader();
    // 1 ~ 1000000
    private int N;
    private int[] num = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    private List<Long> arr = new ArrayList<>();

    public void main() {
        input();
        solve();
    }

    private void input() {
        N = scan.nextInt();
    }

    private void solve() {
        if (N > 1023) {
            System.out.println(-1);
            return;
        }
        dfs(0L, 0);

        Collections.sort(arr);
        System.out.println(arr.get(N - 1));
    }

    private void dfs(Long sum, int index) {
        if (!arr.contains(sum)) {
            arr.add(sum);
        }

        if (index >= 10) {
            return;
        }

        dfs(sum * 10 + num[index], index + 1);
        dfs(sum, index + 1);
    }

    public static void main(String[] args) {
        B1174 main = new B1174();
        main.main();
    }
}
