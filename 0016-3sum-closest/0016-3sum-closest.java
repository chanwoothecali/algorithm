class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length, closet = Integer.MAX_VALUE, result = 0;
        for (int i = 0; i < length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int L = i + 1, R = length - 1;
            while (L < R) {
                int sum = nums[L] + nums[R] + nums[i];
                if (sum == target) {
                    return target;
                } else if (sum > target) {
                    R--;
                } else {
                    L++;
                }
                int abs = Math.abs(sum - target);
                if (closet > abs) {
                    closet = abs;
                    result = sum;
                }
            }
        }
        return result;
    }
}