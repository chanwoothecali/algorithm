class Solution {
    public char kthCharacter(int k) {
        int ones = Integer.bitCount(k - 1);
        return (char) ('a' + ones);
    }
}