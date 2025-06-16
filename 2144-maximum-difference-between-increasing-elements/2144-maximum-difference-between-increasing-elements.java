class Solution {
    public int maximumDifference(int[] nums) {
        int result = -1;
        int min = 1_000_000_000;
        for (int num : nums) {
            if (num <= min) {
                min = num;
                continue;
            }
            result = Math.max(result, num - min);
        }

        return result;
    }
}