class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] result = new int[2];
        final int n = grid.length;
        int length = n * n + 1;
        int[] hash = new int[length];

        for (int[] ints : grid) {
            for (int anInt : ints) {
                hash[anInt]++;
            }
        }

        for (int i = 1; i < length; i++) {
            int value = hash[i];
            if (value == 2) {
                result[0] = i;
            }

            if (value == 0) {
                result[1] = i;
            }
        }

        return result;
    }
}