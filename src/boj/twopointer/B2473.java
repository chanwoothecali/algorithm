package boj.twopointer;

import boj.FastReader;

import java.util.Arrays;
import java.util.StringTokenizer;

public class B2473 {

    private final FastReader scan = new FastReader();
    // 3 ~ 5000
    private int N;
    // -10억 ~ 10억
    private int[] solutions;

    public void main() {
        input();
        solve();
    }

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

        long ans = Long.MAX_VALUE;
        int solutionA = 0, solutionB = 0, solutionC = 0;
        for (int index = 0; index < N - 2; index++) {

            int left = index + 1, right = N - 1;
            while (left < right) {
                /*
                  Long.valueOf로 감싼 것은 답이 아니고, (long)으로 하나를 형변환 시켜준 것은 답이다.
                  int끼리 더한 후 Long으로 형변환 시켜주는 것이 아닌,
                  하나를 (long)으로 만들면서 더할때 알아서 형변환 시켜주는 것이 옳은 방법인듯
                  자바를 이해해야할듯
                 */
//                long mixedSolution = Long.valueOf(solutions[index] + solutions[left] + solutions[right]);
                long mixedSolution = (long)solutions[index] + solutions[left] + solutions[right];

                if (ans > Math.abs(mixedSolution)) {
                    solutionA = solutions[index];
                    solutionB = solutions[left];
                    solutionC = solutions[right];
                    ans = Math.abs(mixedSolution);
                }

                if (solutions[left] + solutions[right] > -solutions[index]) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        System.out.println(solutionA + " " + solutionB + " " + solutionC);
    }

    public static void main(String[] args) {
        B2473 main = new B2473();
        main.main();
    }
}
