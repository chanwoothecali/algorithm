package boj;

import java.util.*;

public class B20291 {
    static Map<String, Integer> map = new HashMap<>();
    static int N;
    static FastReader scan = new FastReader();

    static void input() {
        N = scan.nextInt();
        for (int i = 0; i < N; i++) {
            String file = scan.nextLine();
            String extension = file.substring(file.indexOf(".") + 1);
            map.put(extension, map.getOrDefault(extension, 0) + 1);
        }
    }

    static void solve() {
        ArrayList<String> extensions = new ArrayList<>(map.keySet());
        Collections.sort(extensions);
        for (String extension : extensions) {
            System.out.println(extension + " " + map.get(extension));
        }
    }

    public static void main(String[] args) {
        input();
        solve();
    }
}
