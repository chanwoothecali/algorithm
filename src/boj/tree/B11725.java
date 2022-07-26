package boj.tree;

import boj.FastReader;

import java.util.*;

public class B11725 {

    private final FastReader scan = new FastReader();
    // 2 ~ 100,000
    private int N;
    private ArrayList<Integer>[] tree;
    private int[] parent;

    private void main() {
        input();
        dfs(1, 1);
        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }

    private void input() {
        N = scan.nextInt();
        tree = new ArrayList[N + 1];
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            StringTokenizer st = scan.spaceToken();
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            tree[x].add(y);
            tree[y].add(x);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(tree[i]);
        }
    }

    private void dfs(int x, int parentNode) {
        parent[x] = parentNode;
        ArrayList<Integer> children = tree[x];

        for (Integer child : children) {
            if (child == parentNode) continue;
            dfs(child, x);
        }
    }

    public static void main(String[] args) {
        B11725 main = new B11725();
        main.main();
    }
}
