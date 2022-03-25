package boj.sort;

import boj.FastReader;

import java.util.*;

public class B20291 {
    static int N;
    static FastReader scan = new FastReader();
    static String[] extensions;

    static void input() {
        N = scan.nextInt();
        extensions = new String[N];
        for (int i = 0; i < N; i++) {
            String file = scan.nextLine();
            extensions[i] = file.substring(file.indexOf(".") + 1);
        }
    }

    static void solve() {
        Map<String, Integer> map = new HashMap<>();

        for (String extension : extensions) {
            int numberOfExtension = map.get(extension) == null ? 0 : map.get(extension);
            map.put(extension, numberOfExtension + 1);
        }

        ArrayList<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet); // 정렬

        for (String key : keySet) {
            System.out.println(key + " " + map.get(key));
        }
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
