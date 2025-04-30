class Solution {
    public int findNumbers(int[] nums) {
        int evenDigitsCount = 0;
        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) {
                evenDigitsCount++;
            }
        }

        return evenDigitsCount;
    }
}