class Solution {
    public int countServers(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;

        int[] rows = new int[m];
        int[] lines = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rows[i]++;
                    lines[j]++;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (rows[i] > 1 || lines[j] > 1)) {
                    count++;
                }
            }
        }

        return count;
    }
}