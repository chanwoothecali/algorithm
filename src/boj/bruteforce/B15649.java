package boj.bruteforce;

import boj.FastReader;

import java.util.Arrays;

public class B15649 {

    static int N, M;
    static int[] selected, used;

    static StringBuilder sb = new StringBuilder();

    static void input() {
        FastReader reader = new FastReader();
        N = reader.nextInt();
        M = reader.nextInt();
        selected = new int[M + 1];
        used = new int[N + 1];
    }

    static void reqFunc(int k) {
        if(k == M+1) {
            for (int i = 1; i <= M; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        }else {
            for (int i = 1; i <= N; i++) {
                if(used[i] == 1) continue;
                selected[k] = i;
                used[i] = 1;
                reqFunc(k+1);
                selected[k] = 0;
                used[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        input();

        reqFunc(1);
        System.out.println(sb.toString());
    }
}
