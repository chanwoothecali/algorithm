package boj.tree;

import boj.FastReader;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class B14267 {

    private final FastReader scan = new FastReader();
    // 2 ~ 100,000
    private int n, m;
    private ArrayList<Integer>[] subordinates;
    private int[] degrees;

    public void main() {
        input();
        solve();
    }

    private void input() {
        StringTokenizer nmSt = scan.spaceToken();
        n = Integer.parseInt(nmSt.nextToken());
        m = Integer.parseInt(nmSt.nextToken());
        subordinates = new ArrayList[n + 1];
        degrees = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            subordinates[i] = new ArrayList<>();
        }
        StringTokenizer employeeSt = scan.spaceToken();
        for (int i = 1; i <= n; i++) {
            int boss = Integer.parseInt(employeeSt.nextToken());
            if (boss == -1) continue;
            subordinates[boss].add(i);
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = scan.spaceToken();
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            degrees[x] += y;
        }
    }

    private void solve() {
        dfs(1);
        for (int i = 1; i <= n; i++) {
            System.out.print(degrees[i] + " ");
        }
    }

    private void dfs(int x) {
        ArrayList<Integer> juniors = subordinates[x];
        for (Integer junior : juniors) {
            degrees[junior] += degrees[x];
            dfs(junior);
        }
    }

    public static void main(String[] args) {
        B14267 main = new B14267();
        main.main();
    }
}
