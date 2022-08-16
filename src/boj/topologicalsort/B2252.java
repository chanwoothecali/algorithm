package boj.topologicalsort;

import boj.FastReader;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2252 {

    private final FastReader scan = new FastReader();
    // 1 ~ 32,000
    private int N;
    // 1 ~ 100,000
    private int M;
    ArrayList<Integer>[] children;
    ArrayList<Integer>[] parents;
    Queue<Integer> noInDegrees = new LinkedList<>();
    StringBuilder sb = new StringBuilder();

    public void main() {
        input();
        solve();
    }

    private void input() {
        StringTokenizer nmToken = scan.spaceToken();
        N = Integer.parseInt(nmToken.nextToken());
        M = Integer.parseInt(nmToken.nextToken());
        children = new ArrayList[N + 1];
        parents = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            children[i] = new ArrayList<>();
            parents[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = scan.spaceToken();
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            children[x].add(y);
            parents[y].add(x);
        }
        for (int i = 1; i <= N; i++) {
            if (parents[i].isEmpty()) {
                noInDegrees.offer(i);
            }
        }
    }

    private void solve() {

        while (!noInDegrees.isEmpty()) {
            int x = noInDegrees.poll();
            sb.append(x).append(' ');
            ArrayList<Integer> child = children[x];
            for (Integer index : child) {
                parents[index].remove((Integer) x);
                if (parents[index].isEmpty()) noInDegrees.offer(index);
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) {
        B2252 main = new B2252();
        main.main();
    }
}
