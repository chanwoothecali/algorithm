package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class B1764 {
    private FastReader scan = new FastReader();
    private StringBuilder sb = new StringBuilder();

    private int N, M;
    private String[] neverHeard, neverSeen;
    private List<String> neverHeardSeen = new ArrayList<>();

    private void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        neverHeard = new String[N];
        neverSeen = new String[M];
        for (int i = 0; i < N; i++) {
            neverHeard[i] = scan.nextLine();
        }
        for (int i = 0; i < M; i++) {
            neverSeen[i] = scan.nextLine();
        }
    }

    private void solve() {
        Arrays.sort(neverSeen);

        for (int i = 0; i < N; i++) {
            setHaveNeverHeardSeen(neverHeard[i]);
        }

        Collections.sort(neverHeardSeen);
        print();
    }

    private void setHaveNeverHeardSeen(String neverHeardName) {
        int left = 0, right = M - 1;

        while (left <= right) {
            int cursor = (left + right) / 2;
            String neverSeenName = neverSeen[cursor];
            if(neverSeenName.equals(neverHeardName)) {
                neverHeardSeen.add(neverHeardName);
                break;
            } else if (neverSeenName.compareTo(neverHeardName) < 0) {
                left = cursor + 1;
            } else if (neverSeenName.compareTo(neverHeardName) > 0) {
                right = cursor - 1;
            }
        }
    }

    private void print() {
        System.out.println(neverHeardSeen.size());

        for (String s : neverHeardSeen) {
            System.out.println(s);
        }
    }

    public void main() {
        input();
        solve();
    }

    public static void main(String[] args) {
        B1764 b1764 = new B1764();
        b1764.main();
    }
}
