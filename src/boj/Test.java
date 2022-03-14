package boj;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Test {
    private static final FastReader scan = new FastReader();

    public static void main(String[] args) {
        String T = scan.next();
        System.out.println(T);
        StringTokenizer H = scan.spaceToken();
        System.out.println(H.nextToken());
        StringTokenizer L = scan.commaToken();
        System.out.println(L.nextToken(" "));
        System.out.println(L.nextToken());
    }
}

