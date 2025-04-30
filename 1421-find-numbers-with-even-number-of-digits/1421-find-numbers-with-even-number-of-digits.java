class Solution {
    public int findNumbers(int[] nums) {
        int evenDigitsCount = 0;
        for (int num : nums) {
            if (isEvenDigitsCount(num)) {
                evenDigitsCount++;
            }
        }

        return evenDigitsCount;
    }

    private boolean isEvenDigitsCount(int num) {
        int digits = 1;
        while (num / 10 > 0) {
            digits++;
            num /= 10;
        }

        return digits % 2 == 0 ? true : false;
    }
}