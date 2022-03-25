package boj.binary;

import boj.FastReader;

import java.util.StringTokenizer;

public class B2343 {

    private final FastReader scan = new FastReader();
    // 1 ~ 10만
    private int N;
    // 1 ~ N
    private int M;
    // 1 ~ 만
    private int[] lectures;

    public void main() {
        input();
        solve();
    }

    private void input() {
        StringTokenizer st = scan.spaceToken();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lectures = new int[N];

        st = scan.spaceToken();
        for (int i = 0; i < N; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
        }
    }

    private void solve() {
        // 틀렸던 이유. 강의의 길이가 만분이라고 블루레이 길이도 만분이 최대는 아니다.
        // 강의의 수 * 블루레이 수의 최대치인 10억으로 설정
        int left = 1, right = 1000000000;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (determine(mid)) {
                right = mid - 1;
                result = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }

    private boolean determine(int tapeLength) {
        int numberOfTape = 1;
        int oneOfTape = 0;
        for (int i = 0; i < N; i++) {
            if (lectures[i] > tapeLength) return false;

            if (oneOfTape + lectures[i] <= tapeLength) {
                oneOfTape += lectures[i];
            } else {
                oneOfTape = lectures[i];
                numberOfTape++;
            }
        }

        return numberOfTape <= M;
    }

    public static void main(String[] args) {
        B2343 main = new B2343();
        main.main();
    }
}
