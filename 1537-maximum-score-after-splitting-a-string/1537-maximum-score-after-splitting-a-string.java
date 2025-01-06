class Solution {
    public int maxScore(String s) {
        int right = (int) s.chars().filter(c -> c == '1').count();
        int left = 0;
        int result = 0;

        int length = s.length() - 1;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '0') {
                left++;
            } else {
                right--;
            }

            result = Math.max(result, right + left);
        }

        return result;
    }
}