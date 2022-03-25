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
    public String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public StringTokenizer spaceToken() {
        try {
            st = new StringTokenizer(br.readLine(), " ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return st;
    }

    public StringTokenizer commaToken() {
        try {
            st = new StringTokenizer(br.readLine(), ",");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return st;
    }
}
