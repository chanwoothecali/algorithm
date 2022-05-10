package boj.graph;

import boj.FastReader;

import java.util.*;

public class B14502 {

    private final FastReader scan = new FastReader();

    // 3 ~ 8 // 바이러스 개수 2 ~ 10
    private int N, M;
    private int numBlank, ans;
    private int[][] lab, blank;
    private boolean[][] visited;
    private final int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};


    public void main() {
        input();
        solve();
    }

    private void input() {
        StringTokenizer nmToken = scan.spaceToken();
        N = Integer.parseInt(nmToken.nextToken());
        M = Integer.parseInt(nmToken.nextToken());
        lab = new int[N][M];
        blank = new int[N * M + 1][2];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = scan.spaceToken();
            for (int j = 0; j < M; j++) {
                int x = Integer.parseInt(st.nextToken());
                lab[i][j] = x;
                if (x == 0) {
                    numBlank++;
                    blank[numBlank][0] = i;
                    blank[numBlank][1] = j;
                }
            }
        }
    }

    private void solve() {
        dfs(1, 0);
        System.out.println(ans);
    }

    private void dfs(int idx, int wallCnt) {
        if (wallCnt == 3) {
            bfs();
            return;
        }
        if (idx > numBlank) return;

        lab[blank[idx][0]][blank[idx][1]] = 1;
        dfs(idx + 1, wallCnt + 1);
        lab[blank[idx][0]][blank[idx][1]] = 0;
        dfs(idx + 1, wallCnt);
    }

    private void bfs() {
        Queue<Integer> virus = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = false;
                if (lab[i][j] == 2) {
                    virus.offer(i);
                    virus.offer(j);
                    visited[i][j] = true;
                }
            }
        }

        while (!virus.isEmpty()) {
            int x = virus.poll();
            int y = virus.poll();
            for (int i = 0; i < 4; i++) {
                int moveX = x + dir[i][0];
                int moveY = y + dir[i][1];
                if (isNotPossible(moveX, moveY)) continue;
                visited[moveX][moveY] = true;
                virus.offer(moveX);
                virus.offer(moveY);
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (lab[i][j] == 0 && !visited[i][j]) count++;
            }
        }

        ans = Math.max(ans, count);
    }

    private boolean isNotPossible(int x, int y) {

        if (x < 0 || y < 0) {
            return true;
        }

        if (x >= N || y >= M) {
            return true;
        }

        if (lab[x][y] != 0) {
            return true;
        }

        return visited[x][y];
    }

    public static void main(String[] args) {
        B14502 main = new B14502();
        main.main();
    }
}
