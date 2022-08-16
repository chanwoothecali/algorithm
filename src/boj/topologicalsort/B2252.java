package boj.topologicalsort;

import boj.FastReader;

import java.util.*;

public class B2252 {

    private final FastReader scan = new FastReader();
    // 1 ~ 32,000
    private int N;
    // 1 ~ 100,000
    private int M;
    private int[] indeg;
    ArrayList<Integer>[] adj;

    public void main() {
        input();
        solve();
    }

    private void input() {
        StringTokenizer nmToken = scan.spaceToken();
        N = Integer.parseInt(nmToken.nextToken());
        M = Integer.parseInt(nmToken.nextToken());
        adj = new ArrayList[N + 1];
        indeg = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = scan.spaceToken();
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj[x].add(y);
            indeg[y]++;
        }
    }

    private void solve() {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();
            sb.append(x).append(' ');
            for (Integer nextAdj : adj[x]) {
                indeg[nextAdj]--;
                if (indeg[nextAdj] == 0) queue.offer(nextAdj);
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) {
        B2252 main = new B2252();
        main.main();
    }
}
