class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int ans = 0, max = 0, min = 0;
        for (int num : nums) {
            max = Math.max(num, max + num);
            min = Math.min(num, min + num);
            ans = Math.max(ans, Math.max(max, -min));
        }

        return ans;
    }
}