package boj.sort;

import boj.FastReader;

import java.util.Arrays;

public class B1015 {

    static FastReader scan = new FastReader();
    static Element[] B;
    static int[] P;
    static int N;

    static class Element implements Comparable<Element>{
        int idx;
        int num;

        public Element(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }

        @Override
        public int compareTo(Element o) {
            if(this.num == o.num) return this.idx - o.idx;
            return this.num - o.num;
        }
    }

    static void input() {
        N = scan.nextInt();
        B = new Element[N];
        P = new int[N];
        for (int i = 0; i < N; i++) {
            B[i] = new Element(i, scan.nextInt());
        }
    }

    static void func() {
        Arrays.sort(B);

        for (int i = 0; i < N; i++) {
            P[B[i].idx] = i;
        }

        for (int i : P) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        input();
        func();
    }
}
