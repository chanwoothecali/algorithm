package boj.bruteforce;

import boj.FastReader;

public class B9663 {
    static int N, result;
    static int[] cols, used;

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        cols = new int[N + 1];
        used = new int[N + 1];
    }

    static void reqFunc(int level) {
        // 체스판 끝까지 한 번 훑었을 때
        if(level == N + 1) {
            // 가짓수에 하나 추가
            result++;
        }else {
            for (int col = 1; col <= N; col++) {
                if(isPossible(col, level)){
                    cols[level] = col;
                    used[col] = 1;
                    reqFunc(level + 1);
                    cols[level] = 0;
                    used[col] = 0;
                }
            }
        }
    }

    private static boolean isPossible(int col, int level) {
        // 같은 열에 있는 경우                                                                 
        if(used[col] == 1) {
            return false;
        }

        // 대각선에 위치한 경우
        for (int i = 1; i < level; i++) {
            if(col + level == cols[i] + i) {
                return false;
            }else if(col - level == cols[i] - i){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        input();

        reqFunc(1);
        System.out.println(result);
    }
}
