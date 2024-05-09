import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,
            Comparator.comparingInt((int[] o) -> o[1]));

        int count = 1;
        int boundEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; ++i) {
            if (boundEnd <= intervals[i][0]) {
                boundEnd = intervals[i][1];
                ++count;
            }
        }

        return intervals.length - count;
    }
}