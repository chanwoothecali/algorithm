class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        char prev = '0'; int count = 0;
        for (char aChar : chars) {
            if (prev != aChar) {
                sb.append(aChar);
                prev = aChar;
                count = 0;
            } else if (++count < 2) {
                sb.append(aChar);
            }
        }

        return sb.toString();
    }
}