class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long result = 0, count = 0;
        for (int num : nums) {
            if (num == 0) {
                count++;
                continue;
            }

            result += count * (count + 1) / 2;
            count = 0;
        }

        if (count > 0) {
            result += count * (count + 1) / 2;
        }

        return result;
    }
}