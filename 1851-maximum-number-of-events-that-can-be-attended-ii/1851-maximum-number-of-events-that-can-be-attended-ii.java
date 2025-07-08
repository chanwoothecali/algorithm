class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[1])); // 종료일 기준 정렬
        int n = events.length;
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; ++i) {
            int start = events[i - 1][0];
            int value = events[i - 1][2];
            int prev = binarySearch(events, start);

            for (int j = 1; j <= k; ++j) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[prev][j - 1] + value);
            }
        }
        return dp[n][k];
    }

    // 종료일이 start보다 <target인 마지막 인덱스를 이진탐색
    private int binarySearch(int[][] events, int target) {
        int lo = 0, hi = events.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (events[mid][1] < target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}