class Solution {
    public int minimumLength(String s) {
        int[] count = counter(s);
        int result = 0;

        for (int i : count) {
            if (i == 0) {
                continue;
            }

            if (i % 2 == 0) {
                result += 2;
            } else {
                result += 1;
            }
        }

        return result;
    }

    private int[] counter(String s) {
        int[] count = new int[26];
        s.chars().forEach(c -> count[c - 'a']++);
        return count;
    }
}