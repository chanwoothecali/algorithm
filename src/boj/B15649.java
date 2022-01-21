package boj;

import java.util.Arrays;

public class B15649 {

    static int N, M;
    static int[] selected;

    static StringBuilder sb = new StringBuilder();

    static void input() {
        FastReader reader = new FastReader();
        N = reader.nextInt();
        M = reader.nextInt();
        selected = new int[M + 1];
    }

    static void reqFunc(int k) {
        if(k == M+1) {
            for (int i = 1; i <= M; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        }else {
            for (int i = 1; i <= N; i++) {
                if(!isUsed(i)){
                    selected[k] = i;
                    reqFunc(k+1);
                    selected[k] = 0;
                }
            }
        }
    }

    static boolean isUsed(int i) {
        for (int j = 1; j < selected.length; j++) {
            if(selected[j] == i) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        input();

        reqFunc(1);
        System.out.println(sb.toString());
    }
}
