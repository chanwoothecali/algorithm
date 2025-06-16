class Solution {
    public int maximumDifference(int[] nums) {
        int result = -1;
        final int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] >= nums[j]) {
                    continue;
                }
                result = Math.max(result, nums[j] - nums[i]);
            }
        }

        return result;
    }
}