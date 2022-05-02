package boj.graph;

import boj.FastReader;

import java.util.*;

public class B2251 {

    private final FastReader scan = new FastReader();
    // 1 ~ 200
    private int A, B, C;
    private boolean[][][] visit = new boolean[201][201][201];

    // 순서를 보장해주는 TreeSet
    // HashSet 했더니 틀리더라
    private Set<Integer> answers = new TreeSet<>();

    public void main() {
        input();
        solve();
    }

    private void input() {
        StringTokenizer st = scan.spaceToken();
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
    }

    private void solve() {
        dfs(0, 0, C);
        for (Integer answer : answers) {
            System.out.print(answer + " ");
        }
    }

    private void dfs(int a, int b, int c) {
        visit[a][b][c] = true;
        if (a == 0) {
            answers.add(c);
        }
        ArrayList<int[]> beakerList = possibleBeakerList(a, b, c);

        for (int[] beakers : beakerList) {
            if (visit[beakers[0]][beakers[1]][beakers[2]]) continue;
            dfs(beakers[0], beakers[1], beakers[2]);
        }
    }

    private ArrayList<int[]> possibleBeakerList(int a, int b, int c) {
        ArrayList<int[]> bottles = new ArrayList<>();
        if (a < A) {
            if (b > 0) {
                int remainB = Math.max(b - (A - a), 0);
                int filledA = Math.min(a + b, A);
                bottles.add(new int[]{filledA, remainB, c}); // b -> a
            }

            if (c > 0) {
                int remainC = Math.max(c - (A - a), 0);
                int filledA = Math.min(a + c, A);
                bottles.add(new int[]{filledA, b, remainC}); // c -> a
            }
        }

        if (b < B) {
            if (a > 0) {
                int remainA = Math.max(a - (B - b), 0);
                int filledB = Math.min(a + b, B);
                bottles.add(new int[]{remainA, filledB, c}); // a -> b
            }

            if (c > 0) {
                int remainC = Math.max(c - (B - b), 0);
                int filledB = Math.min(b + c, B);
                bottles.add(new int[]{a, filledB, remainC}); // c -> b
            }
        }

        if (c < C) {
            if (a > 0) {
                int remainA = Math.max(a - (C - c), 0);
                int filledC = Math.min(a + c, C);
                bottles.add(new int[]{remainA, b, filledC}); // a -> c
            }

            if (b > 0) {
                int remainB = Math.max(b - (C - c), 0);
                int filledC = Math.min(b + c, C);
                bottles.add(new int[]{a, remainB, filledC}); // b -> c
            }
        }
        return bottles;
    }

    public static void main(String[] args) {
        B2251 main = new B2251();
        main.main();
    }
}
