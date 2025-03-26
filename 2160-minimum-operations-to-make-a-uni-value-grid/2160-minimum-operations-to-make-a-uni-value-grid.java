class Solution {
    public int minOperations(int[][] grid, int x) {
        final int m = grid.length;
        final int n = grid[0].length;
        int[] flat = new int[m * n];

        int index = 0;
        for (int[] row : grid) {
            for (int i : row) {
                flat[index++] = i;
            }
        }

        if (flat.length == 1) {
            return 0;
        }

        Arrays.sort(flat);

        int middle = m * n / 2;
        int a = flat[middle - 1], b = flat[middle];
        int calA = calculateCount(flat, x, a);
        int calB = calculateCount(flat, x, b);
        if (calA == -1 && calB == -1) {
            return -1;
        } else if (calA == -1) {
            return calB;
        } else if (calB == -1) {
            return calA;
        }

        return Math.min(calA, calB);
    }

    private int calculateCount(int[] flat, int x, int middle) {
        int count = 0;
        for (int i : flat) {
            if ((middle - i) % x != 0) {
                return -1;
            }

            if (middle == i) {
                continue;
            }

            count += Math.abs(middle - i) / x;
        }

        return count;
    }
}