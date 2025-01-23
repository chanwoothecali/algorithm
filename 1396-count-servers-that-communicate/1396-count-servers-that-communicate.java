class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] rows = new int[m];
        int[] lines = new int[n];

        int[][] visited = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    rows[i]++;
                    lines[j]++;
                }
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int[] column = queue.poll();
            int row = column[0];
            int line = column[1];

            if (rows[row] > 1 || lines[line] > 1) {
                count++;
                continue;
            }
        }

        return count;
    }
}