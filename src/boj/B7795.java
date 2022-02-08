package boj;

import java.util.Arrays;

/**
 * 단순 비교로 처리할 시 이중 for문으로 O(NM) -> O(N^2)의 시간복잡도를 도출
 * 문제에서 설정된 N,M의 범위는 20,000 -> O(N^2)이면 4억. -> 4초
 * 문제의 제한시간은 1초이기 때문에 4초로는 통과할 수 없다.
 * 때문에 O(NlogN)의 시간복잡도를 도출하는 이분탐색 알고리즘을 채택
 */
public class B7795 {
    private FastReader scan = new FastReader();
    private int T, N, M;
    private int[] A, B;
    private StringBuilder sb = new StringBuilder();

    void solve() {
        T = scan.nextInt();
        // 테스트케이스 별로 수행
        for (int i = 0; i < T; i++) {
            setting();
            sb.append(numberOfPair()).append('\n');
        }
        System.out.println(sb);
    }

    private int numberOfPair() {
        int ans = 0, mid = 0;

        for (int i = 0; i < N; i++) {
            int left = 0, right = M - 1;

            // 왼쪽 범위가 오른쪽 범위를 넘어서면 break;
            while (left <= right) {
                mid = (left + right) / 2;
                // B보다 A가 크거나 같을 경우 오른쪽 범위를 지금 비교한 B의 위치보다 하나 줄임
                if(B[mid] >= A[i]) {
                    right = mid - 1;
                // B보다 A가 작은 경우 왼쪽 범위를 지금 비교한 B의 위치보다 하나 크게 잡음
                }else if(B[mid] < A[i]) {
                    left = mid + 1;
                }
            }
            // B[0] < A[i] < B[1]인 경우 mid가 0으로 도출되기 때문에 경우의 수 1을 더해준다.
            if(B[0] < A[i]) ans += 1;
            ans += mid;
        }

        return ans;
    }

    private void setting() {
        N = scan.nextInt();
        A = new int[N];
        M = scan.nextInt();
        B = new int[M];
        for (int i = 0; i < N; i++) {
            A[i] = scan.nextInt();
        }
        for (int i = 0; i < M; i++) {
            B[i] = scan.nextInt();
        }
        Arrays.sort(B);
    }

    public static void main(String[] args) {
        B7795 b7795 = new B7795();
        b7795.solve();
    }
}
