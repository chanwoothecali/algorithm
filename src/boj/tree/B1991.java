package boj.tree;

import boj.FastReader;

import java.util.StringTokenizer;

public class B1991 {

    private final FastReader scan = new FastReader();
    // 1 ~ 26
    private int N;
    private int[][] children;
    private static final char A = 'A';

    public void main() {
        input();
        preorder(0);
        System.out.println();
        inorder(0);
        System.out.println();
        postorder(0);
    }

    private void input() {
        N = scan.nextInt();
        children = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = scan.spaceToken();
            char curr = st.nextToken().charAt(0);
            int currIndex = curr - A;
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            children[currIndex][0] = left == '.' ? -1 : left - A;
            children[currIndex][1] = right == '.' ? -1 : right - A;
        }
    }

    private void preorder(int curr) {
        if (curr == -1) return;
        System.out.print((char)(curr + 'A'));
        preorder(children[curr][0]);
        preorder(children[curr][1]);
    }

    private void inorder(int curr) {
        if (curr == -1) return;
        inorder(children[curr][0]);
        System.out.print((char)(curr + 'A'));
        inorder(children[curr][1]);
    }

    private void postorder(int curr) {
        if (curr == -1) return;
        postorder(children[curr][0]);
        postorder(children[curr][1]);
        System.out.print((char)(curr + 'A'));
    }

    public static void main(String[] args) {
        B1991 main = new B1991();
        main.main();
    }
}
