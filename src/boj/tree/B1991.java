package boj.tree;

import boj.FastReader;

import java.util.StringTokenizer;

public class B1991 {

    private final FastReader scan = new FastReader();
    // 1 ~ 26
    private int N;
    private int[][] children;
    private boolean[] visited;
    private static final char A = 'A';

    public void main() {
        input();
        preorder(0);
        System.out.println();
        visited = new boolean[N];
        inorder(0);
        System.out.println();
        visited = new boolean[N];
        postorder(0);
    }

    private void input() {
        N = scan.nextInt();
        children = new int[N][2];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = scan.spaceToken();
            char curr = st.nextToken().charAt(0);
            int currIndex = curr - A;
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            if (left != '.') children[currIndex][0] = left - A;
            if (right != '.') children[currIndex][1] = right - A;
        }
    }

    private void preorder(int curr) {
        if (!visited[curr]) {
            System.out.print((char)(curr + 'A'));
            visited[curr] = true;
        }

        if (children[curr][0] != 0) {
            preorder(children[curr][0]);
        }

        if (children[curr][1] != 0) {
            preorder(children[curr][1]);
        }
    }

    private void inorder(int curr) {
        if (children[curr][0] != 0) {
            inorder(children[curr][0]);
        }

        if (!visited[curr]) {
            System.out.print((char)(curr + 'A'));
            visited[curr] = true;
        }

        if (children[curr][1] != 0) {
            inorder(children[curr][1]);
        }
    }

    private void postorder(int curr) {
        if (children[curr][0] != 0) {
            postorder(children[curr][0]);
        }

        if (children[curr][1] != 0) {
            postorder(children[curr][1]);
        }

        if (!visited[curr]) {
            System.out.print((char)(curr + 'A'));
            visited[curr] = true;
        }
    }

    public static void main(String[] args) {
        B1991 main = new B1991();
        main.main();
    }
}
