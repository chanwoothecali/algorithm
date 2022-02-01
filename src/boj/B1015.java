package boj;

import java.util.Arrays;

public class B1015 {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int[] P, B, A;
    static int N;

    static void input() {
        N = scan.nextInt();
        P = new int[N];
        A = new int[N];
        B = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scan.nextInt();
        }
    }

    static void reqFunc() {
        B = sort(A);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(A[i] == B[j]) {
                    P[i] = j;
                    B[j] = -1;
                    break;
                }
            }

        }
    }

    static int[] sort(int[] a) {
        int[] b = a.clone();
        Arrays.sort(b);
        return b;
    }

    static void print() {
        for (int i = 0; i < N; i++) {
            System.out.print(P[i] + " ");
        }
    }

    public static void main(String[] args) {
        input();

        reqFunc();
        print();
    }
}
