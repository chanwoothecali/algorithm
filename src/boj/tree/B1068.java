package boj.tree;

import boj.FastReader;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1068 {

    private final FastReader scan = new FastReader();
    // 1 ~ 50
    private int N, erased, root;
    private ArrayList<Integer>[] children;
    private int[] leaf;

    public void main() {
        input();
        solve();
    }

    private void input() {
        N = scan.nextInt();
        children = new ArrayList[N];
        leaf = new int[N];
        for (int i = 0; i < N; i++) {
            children[i] = new ArrayList<>();
        }
        StringTokenizer st = scan.spaceToken();
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = i;
                continue;
            }
            children[parent].add(i);
        }
        erased = scan.nextInt();
    }

    private void solve() {
        for (int i = 0; i < N; i++) {
            if (children[i].contains(erased)) {
                children[i].remove((Integer) erased);
            }
        }

        if (erased == root) {
            System.out.println(0);
            return;
        }

        dfs(root);

        System.out.println(leaf[root]);
    }

    private int dfs(int curr) {
        int numberOfLeaves = 0;
        ArrayList<Integer> nextNodes = children[curr];

        if (nextNodes.isEmpty()) {
            leaf[curr] = 1;
            return 1;
        }

        for (Integer nextNode : nextNodes) {
            int nextLeaves = dfs(nextNode);
            numberOfLeaves += nextLeaves;
        }
        leaf[curr] = numberOfLeaves;

        return numberOfLeaves;
    }

    public static void main(String[] args) {
        B1068 main = new B1068();
        main.main();
    }
}
