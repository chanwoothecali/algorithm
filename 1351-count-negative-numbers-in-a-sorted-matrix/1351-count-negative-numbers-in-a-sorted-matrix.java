import java.util.Arrays;

class Solution {
    public int countNegatives(int[][] grid) {
        int answer = 0;
        for (int[] ints : grid) {
            Arrays.sort(ints);
            for (int anInt : ints) {
                if (anInt < 0) {
                    answer++;
                } else {
                    break;
                }
            }
        }

        return answer;
    }
}