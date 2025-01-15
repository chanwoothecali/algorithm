class Solution {
    public boolean canConstruct(String s, int k) {
        int[] alphabet = new int[26];
        s.chars().forEach(c -> alphabet[c - 'a']++);

        int numberOfOdd = 0;
        for (int i : alphabet) {
            if (i % 2 == 1) {
                numberOfOdd++;
            }
        }

        if (numberOfOdd > k || s.length() < k) {
            return false;
        }

        return true;
    }
}