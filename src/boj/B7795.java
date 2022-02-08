package boj;

import java.util.Arrays;

/**
 * 단순 비교로 처리할 시 이중 for문으로 O(NM) -> O(N^2)의 시간복잡도를 도출
 * 문제에서 설정된 N,M의 범위는 20,000 -> O(N^2)이면 4억. -> 4초
 * 문제의 제한시간은 1초이기 때문에 4초로는 통과할 수 없다.
 * 때문에 O(NlogN)의 시간복잡도를 도출하는 이분탐색 알고리즘을 채택
 *
 * 1. B 배열 정렬 => O(MlogM)
 * 2. 모든 A의 원소마다 B 배열에 대해 이분 탐색 => O(NlogM)
 * - 총 시간복잡도 = O((N+M)logM) => O(NlogN)
 */
public class B7795 {
    private FastReader scan = new FastReader();
    private int T, N, M;
    private int[] A, B;

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
    }

    void main() {
        T = scan.nextInt();
        for (int i = 0; i < T; i++) {
            setting();
            solve();
        }
    }

    private void solve() {
        Arrays.sort(B);

        int ans = 0;
        for (int index = 0; index < N; index++) {
            ans += lowBound(index);
        }

        System.out.println(ans);
    }

    private int lowBound(int index) {
        int left = 0, right = M - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            // B보다 A가 크거나 같을 경우 오른쪽 범위를 지금 비교한 B의 위치보다 하나 줄임
            if(B[mid] >= A[index]) {
                right = mid - 1;
            // B보다 A가 작은 경우 왼쪽 범위를 지금 비교한 B의 위치보다 하나 크게 잡음
            }else if(B[mid] < A[index]) {
                left = mid + 1;
            }
        }

        // left 값이 본인보다 작은 값들의 수가 된다.
        return left;
    }

    public static void main(String[] args) {
        B7795 b7795 = new B7795();
        b7795.main();
    }
}
