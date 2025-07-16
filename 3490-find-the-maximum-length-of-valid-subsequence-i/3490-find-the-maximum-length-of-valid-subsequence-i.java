class Solution {
    public int maximumLength(int[] nums) {
        int oddCount = 0, evenCount = 0, crossCount = 1;
        boolean isPrevOdd = false;
        final int length = nums.length;

        int first = nums[0];
        if (first % 2 == 0) {
            evenCount++;
        } else {
            isPrevOdd = true;
            oddCount++;
        }

        for (int i = 1; i < length; i++) {
            int num = nums[i];
            boolean isOdd = num % 2 == 1;
            if (isOdd) {
                oddCount++;
            } else {
                evenCount++;
            }

            if (isPrevOdd != isOdd) {
                crossCount++;
                isPrevOdd = isOdd;
            }
        }

        return Math.max(oddCount, Math.max(evenCount, crossCount));
    }
}