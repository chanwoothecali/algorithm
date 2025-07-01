class Solution {
    public int possibleStringCount(String word) {
        int result = 1, gap = 1;
        final int length = word.length();
        String prevStr = String.valueOf(word.charAt(0));
        for (int i = 1; i < length; i++) {
            String str = String.valueOf(word.charAt(i));
            if (str.equals(prevStr)) {
                gap++;
                continue;
            }

            prevStr = str;
            result += gap - 1;
            gap = 1;
        }
        result += gap - 1;

        return result;
    }
}