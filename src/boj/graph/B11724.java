package boj.graph;

import boj.FastReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B11724 {

    private final FastReader scan = new FastReader();
    // 1 ~ 1000
    private int N;
    // 0 ~ 499500
    private int M;

    private ArrayList<Integer>[] arr;
    private boolean[] visited;

    public void main() {
        input();
        solve();
    }

    private void input() {
        StringTokenizer firstToken = scan.spaceToken();
        N = Integer.parseInt(firstToken.nextToken());
        M = Integer.parseInt(firstToken.nextToken());
        visited = new boolean[N + 1];
        arr = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = scan.spaceToken();
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u].add(v);
            arr[v].add(u);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(arr[i]);
        }
    }

    private void solve() {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;
            dfs(i);
            count++;
        }
        System.out.println(count);
    }

    private void dfs(int x) {
        visited[x] = true;
        ArrayList<Integer> nodes = arr[x];

        for (Integer node : nodes) {
            if (visited[node]) continue;
            dfs(node);
        }
    }

    public static void main(String[] args) {
        B11724 main = new B11724();
        main.main();
    }
}
