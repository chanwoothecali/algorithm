package boj.graph;

import boj.FastReader;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2178 {

    private final FastReader scan = new FastReader();

    // 2 ~ 100
    private int N, M;
    private int[][] maze;
    private int[][] distance;
    private int[][] compass = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void main() {
        input();
        solve();
    }

    private void input() {
        StringTokenizer firstToken = scan.spaceToken();
        N = Integer.parseInt(firstToken.nextToken());
        M = Integer.parseInt(firstToken.nextToken());
        maze = new int[N][M];
        distance = new int[N][M];

        for (int i = 0; i < N; i++) {

            String line = scan.nextLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }
    }

    private void solve() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        queue.offer(0);
        distance[0][0] = 1;

        while (!queue.isEmpty()) {
            Integer x = queue.poll();
            Integer y = queue.poll();
            for (int i = 0; i < 4; i++) {
                int mx = x + compass[i][0];
                int my = y + compass[i][1];
                if (isNotRoad(mx, my)) continue;
                queue.offer(mx);
                queue.offer(my);
                distance[mx][my] = distance[x][y] + 1;
            }
        }
        System.out.println(distance[N - 1][M - 1]);
    }

    private boolean isNotRoad(int x, int y) {
        if (x < 0 || y < 0) {
            return true;
        }

        if (x >= N || y >= M) {
            return true;
        }

        if (maze[x][y] == 0) {
            return true;
        }

        return distance[x][y] != 0;
    }

    public static void main(String[] args) {
        B2178 main = new B2178();
        main.main();
    }
}
