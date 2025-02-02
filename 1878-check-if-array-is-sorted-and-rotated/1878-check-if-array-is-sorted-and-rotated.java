class Solution {
    public boolean check(int[] nums) {
        int max = 101;

        int length = nums.length;
        int prev = nums[0];
        for (int i = 1; i < length; i++) {
            int curr = nums[i];
            if (prev <= curr) {
                prev = curr;
                continue;
            }

            if (max == 101) {
                max = prev;
                prev = curr;
                continue;
            }

            return false;
        }

        if (max != 101) {
            int first = nums[0];
            int last = nums[length - 1];
            if (first < last) {
                return false;
            }
        }

        return true;
    }
}