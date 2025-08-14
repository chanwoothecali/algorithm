class Solution {
    public String largestGoodInteger(String num) {
        char[] chars = num.toCharArray();
        int count = 1;
        char prevChar = 'a';
        int max = -1;
        for (char aChar : chars) {
            if (prevChar == aChar) {
                count++;
            } else {
                count = 1;
            }

            if (count == 3) {
                max = Math.max(max, aChar - '0');
            }

            prevChar = aChar;
        }

        return max >= 0 ? String.valueOf(max).repeat(3) : "";
    }
}