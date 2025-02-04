class Solution {
    public int maxAscendingSum(int[] nums) {
        int result = nums[0], count = nums[0];
        final int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                count += nums[i];
                result = Math.max(result, count);
                continue;
            }

            count = nums[i];
        }

        return result;
    }
}