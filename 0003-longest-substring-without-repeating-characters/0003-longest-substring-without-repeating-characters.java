class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.equals("")) {
            return 0;
        }
        String[] strings = s.split("");
        String subStrings = "";
        String longestString = "";
        for (String string : strings) {
            if (subStrings.contains(string)) {
                subStrings = subStrings.substring(subStrings.indexOf(string) + 1) + string;
            } else {
                subStrings += string;
            }
            if (longestString.length() < subStrings.length()) {
                longestString = subStrings;
            }
        }
        return longestString.length();
    }
}