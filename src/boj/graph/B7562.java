package boj.graph;

import boj.FastReader;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7562 {

    private final FastReader scan = new FastReader();

    private int size, x1, y1, x2, y2;
    private int[][] board;
    private int[][] knightMove = {{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}};
    private StringBuilder sb = new StringBuilder();

    public void main() {
        int count = scan.nextInt();
        for (int i = 0; i < count; i++) {
            input();
            sb.append(bfs()).append('\n');
        }
        System.out.println(sb);
    }

    private void input() {
        size = scan.nextInt();
        board = new int[size][size];
        StringTokenizer st1 = scan.spaceToken();
        x1 = Integer.parseInt(st1.nextToken());
        y1 = Integer.parseInt(st1.nextToken());
        StringTokenizer st2 = scan.spaceToken();
        x2 = Integer.parseInt(st2.nextToken());
        y2 = Integer.parseInt(st2.nextToken());
    }

    private int bfs() {
        if (x1 == x2 && y1 == y2) {
            return 0;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x1);
        queue.offer(y1);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();
            for (int i = 0; i < 8; i++) {
                int mx = x + knightMove[i][0];
                int my = y + knightMove[i][1];
                if (isNotPossible(mx, my)) continue;
                queue.offer(mx);
                queue.offer(my);
                board[mx][my] = board[x][y] + 1;
            }
        }

        return board[x2][y2];
    }

    private boolean isNotPossible(int x, int y) {
        if (x < 0 || y < 0) return true;

        if (x >= size || y >= size) return true;

        return board[x][y] != 0;
    }

    public static void main(String[] args) {
        B7562 main = new B7562();
        main.main();
    }
}
