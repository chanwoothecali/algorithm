package boj.topologicalsort;

import boj.FastReader;

import java.util.*;

public class B1005 {

    private final FastReader scan = new FastReader();
    private StringBuilder sb = new StringBuilder();
    // 2 ~ 1,000
    private int N;
    // 1 ~ 100,000
    private int K;
    // 1 ~ N
    private int W;
    private int[] Dy;
    private ArrayList<Integer>[] children;
    private int[] maxTime;
    private int[] indeg;

    public void main() {
        int t = scan.nextInt();
        for (int i = 0; i < t; i++) {
            input();
            solve();
        }
        System.out.println(sb);
    }

    private void input() {
        StringTokenizer nkToken = scan.spaceToken();
        N = Integer.parseInt(nkToken.nextToken());
        K = Integer.parseInt(nkToken.nextToken());
        children = new ArrayList[N + 1];
        maxTime = new int[N + 1];
        indeg = new int[N + 1];
        Dy = new int[N + 1];
        StringTokenizer dToken = scan.spaceToken();
        for (int i = 1; i <= N; i++) {
            children[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            int d = Integer.parseInt(dToken.nextToken());
            Dy[i] = d;
        }
        for (int i = 1; i <= K; i++) {
            StringTokenizer st = scan.spaceToken();
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            children[x].add(y);
            indeg[y]++;
        }
        W = scan.nextInt();
    }

    private void solve() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
                maxTime[i] = Dy[i];
            }
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (Integer child : children[x]) {
                if (--indeg[child] == 0) {
                    queue.offer(child);
                }
                if (maxTime[child] < Dy[child] + maxTime[x]) {
                    maxTime[child] = Dy[child] + maxTime[x];
                }
            }
        }

        sb.append(maxTime[W]).append('\n');
    }

    public static void main(String[] args) {
        B1005 main = new B1005();
        main.main();
    }
}
