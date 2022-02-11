package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B2470 {
    private FastReader scan = new FastReader();
    private int N;
    private List<Integer> acid = new ArrayList<>(), alkali = new ArrayList<>();

    private void input() {
        N = scan.nextInt();
        for (int i = 0; i < N; i++) {
            int solution = scan.nextInt();
            classify(solution);
        }
    }

    private void classify(int solution) {
        if (solution < 0) {
            acid.add(Math.abs(solution));
        } else if (solution > 0) {
            alkali.add(solution);
        }
    }

    private void solve() {
        Collections.sort(acid);
        int mixedSolution = Integer.MAX_VALUE;
        int a = 0, b = 0;

        for (int alkaliIndex = 0; alkaliIndex < alkali.size(); alkaliIndex++) {
            int acidMidIndex = findAcidMid(alkali.get(alkaliIndex));
            int acidIndex = findAcidIndex(acidMidIndex, alkaliIndex);

            int mixed = alkali.get(alkaliIndex) - acid.get(acidIndex);
            if (Math.abs(mixedSolution) > Math.abs(mixed)) {
                mixedSolution = mixed;
                a = acidIndex;
                b = alkaliIndex;
            }
        }

        System.out.println(-acid.get(a) + " " + alkali.get(b));
    }

    private int findAcidMid(Integer alkaliSolution) {
        int left = 0, right = acid.size() - 1;
        int mid = (left + right) / 2;

        while (left <= right) {
            mid = (left + right) / 2;
            int acidSolution = acid.get(mid);
            if (acidSolution > alkaliSolution) {
                right = mid - 1;
            } else if (acidSolution < alkaliSolution) {
                left = mid + 1;
            } else {
               return mid;
            }
        }
        return mid;
    }

    private int findAcidIndex(int acidIndex, int alkaliIndex) {
        if (acidIndex + 1 == acid.size() || acid.size() < 2) {
            return acidIndex;
        }

        int mixedA = alkali.get(alkaliIndex) - acid.get(acidIndex);
        int mixedB = alkali.get(alkaliIndex) - acid.get(acidIndex + 1);
        if (mixedA >= mixedB) {
            return acidIndex;
        } else {
            return acidIndex + 1;
        }
    }

    public void main() {
        input();
        if (acid.isEmpty()) {
            Collections.sort(alkali);
            System.out.println(alkali.get(0) + " " + alkali.get(1));
            return;
        }

        if (alkali.isEmpty()) {
            Collections.sort(acid);
            System.out.println(acid.get(0) + " " + acid.get(1));
            return;
        }
        solve();
    }

    public static void main(String[] args) {
        B2470 b2470 = new B2470();
        b2470.main();
    }
}
