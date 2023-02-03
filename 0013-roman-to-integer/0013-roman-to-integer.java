class Solution {
    public int romanToInt(String s) {
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] integers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int index = 0, result = 0;
        while (!s.isEmpty()) {
            String startStr = roman[index];
            if (s.startsWith(startStr)) {
                result += integers[index];
                s = s.substring(startStr.length());
            } else {
                index++;
            }
        }
        return result;
    }
}