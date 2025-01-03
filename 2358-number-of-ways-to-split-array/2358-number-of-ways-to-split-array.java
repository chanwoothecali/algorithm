class Solution {
    public int waysToSplitArray(int[] nums) {
        int result = 0;

        long sum = 0;
        int length = nums.length;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        long front = 0, back = sum;

        for (int i = 0; i < length - 1; i++) {
            int current = nums[i];
            front += current;
            back -= current;
            if (front >= back) result++;
        }

        return result;
    }
}