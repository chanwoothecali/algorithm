class Solution {
    public long maximumTripletValue(int[] nums) {
        long ans = 0l, diff = 0l;
        int max = 0;
        for (int num : nums) {
            ans = Math.max(ans, diff * num);
            diff = Math.max(diff, max - num);
            max = Math.max(max, num);
        }

        return ans;
    }
}