package boj.graph;

import boj.FastReader;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B3055 {

    private final FastReader scan = new FastReader();

    // 1 ~ 50
    private int R, C;
    private char[][] map;
    private int[][] visited;
    private int[][] floodingTime;
    private int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public void main() {
        input();
        solve();
    }

    private void input() {
        StringTokenizer st = scan.spaceToken();
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new int[R][C];
        floodingTime = new int[R][C];
        for (int i = 0; i < R; i++) {
            String mapLine = scan.nextLine();
            map[i] = mapLine.toCharArray();
        }
    }

    private void solve() {
        int startX = 0, startY = 0;
        int finishX = 0, finishY = 0;

        // 침수시간 계산
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '*') {
                    flood(i, j);
                }

                if (map[i][j] == 'S') {
                    startX = i;
                    startY = j;
                }

                if (map[i][j] == 'D') {
                    finishX = i;
                    finishY = j;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(floodingTime[i][j]);
            }
            System.out.println();
        }

        /*escape(startX, startY);

        if (visited[finishX][finishY] != 0) {
            System.out.println(visited[finishX][finishY]);
        } else {
            System.out.println("KAKTUS");
        }*/
    }

    private void flood(int sx, int sy) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(sx);
        queue.offer(sy);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();

//            System.out.println("x = " + x + ", y = " + y);
            for (int i = 0; i < 4; i++) {
                int mx = x + dir[i][0];
                int my = y + dir[i][1];
                int currFloodTime = floodingTime[x][y];
                if (isNotPossibleToFlooding(mx, my, currFloodTime)) continue;
                queue.offer(mx);
                queue.offer(my);
                floodingTime[mx][my] = currFloodTime + 1;
            }
        }
    }

    private boolean isNotPossibleToFlooding(int x, int y, int floodTime) {
        System.out.println("x = " + x + ", y = " + y);
        if (x < 0 || y < 0) {
            System.out.println("test1");
            return true;
        }

        if (x >= R || y >= C) {
            System.out.println("test2");
            return true;
        }

        if (floodingTime[x][y] <= floodTime + 1 && floodingTime[x][y] != 0) {
            System.out.println("test3");
            return true;
        }

        System.out.println(map[x][y] != '.' || map[x][y] != 'S');

        return map[x][y] != '.' || map[x][y] != 'S';
    }

    private void escape(int sx, int sy) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(sx);
        queue.offer(sy);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();
            for (int i = 0; i < 4; i++) {
                int mx = x + dir[i][0];
                int my = y + dir[i][1];
                int currTime = visited[x][y];
                if (isNotPossibleToVisit(mx, my, currTime)) continue;
                queue.offer(mx);
                queue.offer(my);
                visited[mx][my] = currTime + 1;
            }
        }
    }

    private boolean isNotPossibleToVisit(int x, int y, int currTime) {
        if (x < 0 || y < 0) return true;

        if (x >= R || y >= C) return true;

        if (floodingTime[x][y] <= currTime + 1 && floodingTime[x][y] != 0) return true;

        return map[x][y] != '.' || map[x][y] != 'D';
    }

    public static void main(String[] args) {
        B3055 main = new B3055();
        main.main();
    }
}
