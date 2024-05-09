class Solution {
    public String intToRoman(int num) {
        int[] codeInt = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (num > 0) {
            int share = num / codeInt[i];
            for (int j = 0; j < share; j++) {
                result.append(romans[i]);
            }
            num -= share * codeInt[i];
            i++;
        }
        return result.toString();
    }
}