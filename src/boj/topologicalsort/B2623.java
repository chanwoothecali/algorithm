package boj.topologicalsort;

import boj.FastReader;

import java.util.*;

public class B2623 {

    private final FastReader scan = new FastReader();
    private StringBuilder sb = new StringBuilder();
    // 1 ~ 1,000
    private int N;
    // 1 ~ 100
    private int M;
    private int[] indeg;
    private ArrayList<Integer>[] children;

    public void main() {
        input();
        solve();
    }

    private void input() {
        StringTokenizer nmToken = scan.spaceToken();
        N = Integer.parseInt(nmToken.nextToken());
        M = Integer.parseInt(nmToken.nextToken());
        indeg = new int[N + 1];
        children = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            children[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = scan.spaceToken();
            int num = Integer.parseInt(st.nextToken());
            int curr = Integer.parseInt(st.nextToken());
            for (int j = 1; j < num; j++) {
                int next = Integer.parseInt(st.nextToken());
                children[curr].add(next);
                indeg[next]++;
                curr = next;
            }
        }
    }

    private void solve() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) queue.offer(i);
        }
        int i = 0;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            i++;
            sb.append(x).append('\n');
            for (Integer nextVal : children[x]) {
                if (--indeg[nextVal] == 0) queue.offer(nextVal);
            }
        }
        if (i == N) {
            System.out.println(sb);
        } else {
            System.out.println(0);
        }
    }

    public static void main(String[] args) {
        B2623 main = new B2623();
        main.main();
    }
}
