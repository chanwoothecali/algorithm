package boj.tree;

import boj.FastReader;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class B20364 {

    private final FastReader scan = new FastReader();

    // 2 ~ 2^20
    private int N;
    // 1 ~ 200,000
    private int Q;
    // 2 ~ N
    private int[] results;
    private boolean[] lands;
    private ArrayList<Integer>[] route;

    public void main() {
        input();
        for (int i = 0; i < Q; i++) {
            System.out.println(results[i]);
        }
    }

    private void input() {
        StringTokenizer st = scan.spaceToken();
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        results = new int[Q];
        lands = new boolean[N + 1];
        for (int i = 0; i < Q; i++) {
            int x = scan.nextInt();
            if (i != 0) {
                int result = solve(x);
                results[i] = result;
            }
            lands[x] = true;
        }
    }

    private int solve(int x) {
        int landNum = x;
        int wall = 0;
        while (landNum > 0) {
            if (lands[landNum]) wall = landNum;
            landNum = landNum / 2;
        }

        return wall;
    }

    public static void main(String[] args) {
        B20364 main = new B20364();
        main.main();
    }
}
