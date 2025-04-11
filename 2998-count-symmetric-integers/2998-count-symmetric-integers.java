class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            String s = String.valueOf(i);
            int length = s.length();
            if (length % 2 == 1) {
                i = (i / 10 + 1) * 10;
                continue;
            }

            int half = length / 2;
            int pow = (int) Math.pow(10, half);
            if (sumOfDigits(i / pow) == sumOfDigits(i % pow)) {
                count++;
            }
        }

        return count;
    }

    private int sumOfDigits(int num) {
        int answer = 0;
        while (num > 0) {
            answer += num % 10;
            num /= 10;
        }

        return answer;
    }
}