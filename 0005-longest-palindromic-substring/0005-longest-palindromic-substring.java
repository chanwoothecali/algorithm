class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }

        String longestStr = "";
        for (int i = 0; i < s.length() - 1; i++) {
            String oddPalindrome = oddPalindrome(s, i, 1);
            if (longestStr.length() < oddPalindrome.length()) {
                longestStr = oddPalindrome;
            }
            if (s.charAt(i) == s.charAt(i + 1)) {
                String evenPalindrome = evenPalindrome(s, i, 1);
                if (longestStr.length() < evenPalindrome.length()) {
                    longestStr = evenPalindrome;
                }
            }
            System.out.println("longestStr = " + longestStr);
        }
        return longestStr;
    }

    private String oddPalindrome(String s, int index, int level) {
        String prevStr = s.substring(index - level + 1, index + level);

        if (index - level < 0 || index + level >= s.length()) {
            return prevStr;
        }

        String leftStr = String.valueOf(s.charAt(index - level));
        String rightStr = String.valueOf(s.charAt(index + level));
        String nextStr = "";
        if (leftStr.equals(rightStr)) {
            nextStr = oddPalindrome(s, index, level + 1);
        }

        String returnStr = prevStr;
        if (prevStr.length() < nextStr.length()) {
            returnStr = nextStr;
        }

        return returnStr;
    }

    private String evenPalindrome(String s, int index, int level) {
        String prevStr = s.substring(index - level + 1, index + level + 1);

        if (index - level < 0 || index + level + 1 >= s.length()) {
            return prevStr;
        }

        String leftStr = String.valueOf(s.charAt(index - level));
        String rightStr = String.valueOf(s.charAt(index + level + 1));
        String nextStr = "";
        if (leftStr.equals(rightStr)) {
            nextStr = evenPalindrome(s, index, level + 1);
        }

        String returnStr = prevStr;
        if (prevStr.length() < nextStr.length()) {
            returnStr = nextStr;
        }

        return returnStr;
    }
}