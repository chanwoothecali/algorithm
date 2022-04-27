package boj.graph;

import boj.FastReader;

import java.util.StringTokenizer;

public class B1012 {

    private final FastReader scan = new FastReader();
    private int T;
    // 1 ~ 50
    private int M;
    // 1 ~ 50
    private int N;
    // 1 ~ 2500
    private int K;
    private int[][] farm;
    private int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private boolean[][] visit;
    StringBuilder sb = new StringBuilder();

    public void main() {
        T = scan.nextInt();
        for (int i = 0; i < T; i++) {
            input();
            solve();
        }
        System.out.println(sb.toString());
    }

    private void input() {
        StringTokenizer mainToken = scan.spaceToken();
        M = Integer.parseInt(mainToken.nextToken());
        N = Integer.parseInt(mainToken.nextToken());
        K = Integer.parseInt(mainToken.nextToken());
        farm = new int[M][N];
        for (int i = 0; i < K; i++) {
            StringTokenizer xyToken = scan.spaceToken();
            int x = Integer.parseInt(xyToken.nextToken());
            int y = Integer.parseInt(xyToken.nextToken());
            farm[x][y] = 1;
        }
    }

    private void solve() {
        visit = new boolean[M][N];
        int warms = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (farm[i][j] == 0) continue;
                if (visit[i][j]) continue;
                dfs(i, j);
                warms++;
            }
        }
        sb.append(warms).append('\n');
    }

    private void dfs(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int moveX = x + dir[i][0];
            int moveY = y + dir[i][1];
            if (isOut(moveX, moveY)) continue;
            if (visit[moveX][moveY]) continue;
            if (farm[moveX][moveY] == 0) continue;
            dfs(moveX, moveY);
        }
    }

    private boolean isOut(int x, int y) {
        return x < 0 || x >= M || y < 0 || y >= N;
    }

    public static void main(String[] args) {
        B1012 main = new B1012();
        main.main();
    }
}
