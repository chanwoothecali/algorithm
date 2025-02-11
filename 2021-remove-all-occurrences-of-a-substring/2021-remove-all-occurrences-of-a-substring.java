class Solution {
    public String removeOccurrences(String s, String part) {
        final int partLen = part.length();

        while (s.contains(part)) {
            int i = s.indexOf(part);
            s = s.substring(0, i) + s.substring(i + partLen);
        }

        return s;
    }
}