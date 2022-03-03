package boj;

import java.io.*;
import java.util.StringTokenizer;

public class FastReader {
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

    StringTokenizer spaceToken() {
        try {
            st = new StringTokenizer(br.readLine(), " ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return st;
    }

    StringTokenizer commaToken() {
        try {
            st = new StringTokenizer(br.readLine(), ",");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return st;
    }
}
