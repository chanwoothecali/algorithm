package boj.graph;

import boj.FastReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B2606 {

    private final FastReader scan = new FastReader();
    // 1 ~ 100
    private int V;
    // 0 ~ 4950
    private int E;
    private ArrayList<Integer>[] computers;
    private boolean[] visit;
    private int virus = 0;

    public void main() {
        input();
        dfs(1);
        System.out.println(virus);
    }

    private void input() {
        V = scan.nextInt();
        E = scan.nextInt();
        computers = new ArrayList[V + 1];
        visit = new boolean[V + 1];
        for (int i = 1; i < V + 1; i++) {
            computers[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            StringTokenizer st = scan.spaceToken();
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            computers[x].add(y);
            computers[y].add(x);
        }
        for (int i = 1; i < V + 1; i++) {
            Collections.sort(computers[i]);
        }
    }

    private void dfs(int x) {
        visit[x] = true;
        ArrayList<Integer> linkedComputers = computers[x];

        for (Integer linkedComputer : linkedComputers) {
            if (visit[linkedComputer]) continue;
            virus++;
            dfs(linkedComputer);
        }
    }

    public static void main(String[] args) {
        B2606 main = new B2606();
        main.main();
    }
}
