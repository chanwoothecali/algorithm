package boj.binary;

import boj.FastReader;

import java.util.Arrays;
import java.util.StringTokenizer;

public class B2470 {
    private final FastReader scan = new FastReader();
    //
    private int N;
    private int[] solutions;

    private void input() {
        N = scan.nextInt();

        solutions = new int[N];
        StringTokenizer st = scan.spaceToken();
        for (int i = 0; i < N; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
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

    private void solveTwoPointer() {
        Arrays.sort(solutions);

        StringBuilder sb = new StringBuilder();

        int ans = Integer.MAX_VALUE;
        int v1 = 0, v2 = 0, L = 0, R = N - 1;

        while (L < R){  // L == R 인 상황이면 용액이 한 개 뿐인 것이므로, L < R 일 때까지만 반복한다.
            int mixedSolution = solutions[L] + solutions[R];

            if (ans > Math.abs(mixedSolution)) {
                v1 = solutions[L];
                v2 = solutions[R];
                ans = Math.abs(mixedSolution);
            }

            if (mixedSolution == 0) {
                v1 = solutions[L];
                v2 = solutions[R];
                break;
            } else if (mixedSolution < 0) {
                L++;
            } else {
                R--;
            }
        }
        sb.append(v1).append(' ').append(v2);
        System.out.println(sb);
    }

    public void main() {
        input();
//        solve();
        solveTwoPointer();
    }

    public static void main(String[] args) {
        B2470 b2470 = new B2470();
        b2470.main();
    }
}
