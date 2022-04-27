package boj.graph;

import boj.FastReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B2667 {

    private final FastReader scan = new FastReader();
    // 5 ~ 25
    private int N;

    private int houseCount;
    private char[][] town;
    private boolean[][] visit;
    private List<Integer> group = new ArrayList<>();
    private int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public void main() {
        input();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visit[i][j]) continue;
                if (town[i][j] == '0') continue;
                houseCount = 0;
                dfs(i, j);
                group.add(houseCount);
            }
        }

        Collections.sort(group);
        System.out.println(group.size());
        for (Integer integer : group) {
            System.out.println(integer);
        }
    }

    private void input() {
        N = scan.nextInt();
        town = new char[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String houses = scan.nextLine();
            town[i] = houses.toCharArray();
        }
    }

    private void dfs(int x, int y) {
        houseCount++;
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int moveX = x + dir[i][0];
            int moveY = y + dir[i][1];
            if (isOut(moveX, moveY)) continue;
            if (visit[moveX][moveY]) continue;
            if (town[moveX][moveY] == '0') continue;
            dfs(moveX, moveY);
        }
    }

    private boolean isOut(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= N;
    }

    public static void main(String[] args) {
        B2667 main = new B2667();
        main.main();
    }
}
