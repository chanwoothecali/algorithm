class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int result = 1;
        final int len = nums.length;

        int increaseSize = 1, decreaseSize = 1;
        int prev = nums[0];
        for (int i = 1; i < len; i++) {
            int cur = nums[i];
            if (cur > prev) {
                result = Math.max(result, ++increaseSize);
                decreaseSize = 1;
            } else if (cur < prev) {
                result = Math.max(result, ++decreaseSize);
                increaseSize = 1;
            } else {
                increaseSize = 1;
                decreaseSize = 1;
            }

            prev = cur;
        }

        return result;
    }
}