package boj.graph;

import boj.FastReader;

import java.util.*;

public class B1260 {
    private final FastReader scan = new FastReader();
    // 1 ~ 1000
    private int N;
    // 1 ~ 10000
    private int M;

    private int V;
    boolean[] visit;
    private StringBuilder sb = new StringBuilder();

    ArrayList<Integer>[] adj;

    public void main() {
        input();
        visit = new boolean[N + 1];
        dfs(V);
        System.out.println(sb);
        visit = new boolean[N + 1];
        sb = new StringBuilder();
        bfs(V);
        System.out.println(sb);
    }

    private void input() {
        StringTokenizer st = scan.spaceToken();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = scan.spaceToken();
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            adj[v1].add(v2);
            adj[v2].add(v1);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);
        }
    }

    private void dfs(int start) {
        visit[start] = true;
        sb.append(start).append(' ');
        ArrayList<Integer> nodes = adj[start];
        for (Integer node : nodes) {
            if (visit[node]) continue;

            dfs(node);
        }
    }

    private void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visit[start] = true;
        sb.append(start).append(' ');

        while (!queue.isEmpty()) {
            int nextNode = queue.poll();
            ArrayList<Integer> nodes = adj[nextNode];

            for (Integer node : nodes) {
                if (visit[node]) continue;
                queue.offer(node);
                visit[node] = true;
                sb.append(node).append(' ');
            }
        }
    }


    public static void main(String[] args) {
        B1260 main = new B1260();
        main.main();
    }
}
