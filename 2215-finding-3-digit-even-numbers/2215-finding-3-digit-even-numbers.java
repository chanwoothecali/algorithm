class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> evenNumbers = new HashSet<>();
        int length = digits.length;
        for (int i = 0; i < length; i++) {
            int first = digits[i] * 100;
            if (first == 0) {
                continue;
            }
            for (int j = 0; j < length; j++) {
                if (i == j) continue;
                int second = digits[j] * 10;
                for (int k = 0; k < length; k++) {
                    if (k == j || k == i) continue;
                    int third = digits[k];
                    if (third % 2 != 0) {
                        continue;
                    }
                    evenNumbers.add(first + second + third);
                }
            }
        }

        return evenNumbers.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}