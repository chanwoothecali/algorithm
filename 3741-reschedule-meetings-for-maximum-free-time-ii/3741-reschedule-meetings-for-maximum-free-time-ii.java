class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;

        // Step 1: 정렬 (startTime 기준)
        int[][] meetings = new int[n][2];
        for (int i = 0; i < n; i++) {
            meetings[i][0] = startTime[i];
            meetings[i][1] = endTime[i];
        }
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        // Step 2: gap 계산 (n+1개)
        int[] gaps = new int[n + 1];
        gaps[0] = meetings[0][0]; // 첫 미팅 전 gap
        for (int i = 1; i < n; i++) {
            gaps[i] = meetings[i][0] - meetings[i - 1][1];
        }
        gaps[n] = eventTime - meetings[n - 1][1]; // 마지막 미팅 후 gap

        // Step 3: prefix, suffix 최대 gap 계산
        int[] maxLeft = new int[n + 1];
        int[] maxRight = new int[n + 1];

        maxLeft[0] = gaps[0];
        for (int i = 1; i <= n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], gaps[i]);
        }

        maxRight[n] = gaps[n];
        for (int i = n - 1; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], gaps[i]);
        }

        // Step 4: 한 개 회의만 재배치하여 최대 free time 계산
        int maxFree = 0;
        for (int i = 0; i < n; i++) {
            int duration = meetings[i][1] - meetings[i][0];
            int adjacentGapSum = gaps[i] + gaps[i + 1];

            // i번째 회의를 다른 위치로 옮길 수 있는가?
            int maxOtherGap = Math.max(
                i > 0 ? maxLeft[i - 1] : 0,
                (i + 2 <= n) ? maxRight[i + 2] : 0
            );

            if (duration <= maxOtherGap) {
                maxFree = Math.max(maxFree, adjacentGapSum + duration);
            } else {
                maxFree = Math.max(maxFree, adjacentGapSum);
            }
        }

        return maxFree;
    }
}