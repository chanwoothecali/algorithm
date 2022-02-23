package boj;

import java.util.Arrays;

public class B2470 {
    private final FastReader scan = new FastReader();
    private int N;
    private int[] solutions;

    private void input() {
        N = scan.nextInt();
        solutions = new int[N];
        for (int i = 0; i < N; i++) {
            solutions[i] = scan.nextInt();
        }
    }

    private void solve() {
        Arrays.sort(solutions);

        int result = Integer.MAX_VALUE;
        int v1 = 0, v2 = 0;

        for (int i = 0; i < N - 1; i++) {
            int candidate = findOppositeIndex(solutions[i], i);
            int opposite = checkCandidate(i, candidate);

            if (result > Math.abs(solutions[opposite] + solutions[i])) {
                result = Math.abs(solutions[opposite] + solutions[i]);
                v1 = solutions[i];
                v2 = solutions[opposite];
            }
        }

        System.out.println(v1 + " " + v2);
    }

    private int checkCandidate(int currIndex, int candidate) {
        System.out.println(currIndex + " " + candidate);
        if (candidate >= N) return candidate - 1;

        if (candidate - 1 == currIndex) return candidate;

        if (candidate == currIndex) return candidate - 1;

        int result1 = Math.abs(solutions[currIndex] + solutions[candidate]);
        int result2 = Math.abs(solutions[currIndex] + solutions[candidate - 1]);


        if (result1 <= result2) {
            return candidate;
        } else {
            return candidate - 1;
        }
    }

    private int findOppositeIndex(int v1, int index) {
        int left = index + 1, right = N - 1;
        int result = right + 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (solutions[mid] == -v1) {
                return mid;
            } else if (solutions[mid] > -v1) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public void main() {
        input();
        solve();
    }

    public static void main(String[] args) {
        B2470 b2470 = new B2470();
        b2470.main();
    }
}
