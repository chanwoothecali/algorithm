package boj;

import boj.binary.B7795;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] selected;

    static StringBuilder sb = new StringBuilder();

    static void input() {
        FastReader reader = new FastReader();
        N = reader.nextInt();
        M = reader.nextInt();
        selected = new int[M + 1];
    }

    static void print(StringBuilder sb) {
        System.out.println(sb.toString());
    }

    static void reqFunc(int k) {
        if (k == M + 1) {
            for (int i = 1; i < k; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        }else {
            for (int i = 1; i <= N; i++) {
                boolean isPassed = true;
                for (int j = 1; j < k; j++) {
                    if (selected[j] > i) {
                        isPassed = false;
                        break;
                    }
                }
                if(isPassed) {
                    selected[k] = i;
                    reqFunc(k + 1);
                    selected[k] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
//        B7795 b7795 = new B7795();
        B7795.main(new String[]{""});
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(s));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
        double nextDouble() {
            return Double.parseDouble(next());
        }
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}

