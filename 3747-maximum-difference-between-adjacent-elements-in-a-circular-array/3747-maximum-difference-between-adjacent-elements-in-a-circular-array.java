class Solution {
    public int maxAdjacentDistance(int[] nums) {
        final int length = nums.length;
        int result = Math.abs(nums[0] - nums[length - 1]);
        for (int i = 1; i < length; i++) {
            result = Math.max(result, Math.abs(nums[i] - nums[i - 1]));
        }

        return result;
    }
}