class Solution {
    public char kthCharacter(long k, int[] operations) {
        int n = (int) Math.ceil(Math.log(k) / Math.log(2));
        int increases = 0;
        for (int i = n - 1; i >= 0; i--) {
            long half = 1L << i;
            if (k > half) {
                k -= half;
                increases += operations[i];
            }
        }
        return (char) ('a' + (increases % 26));
    }
}