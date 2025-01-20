class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] positions = new int[m * n + 1][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int value = mat[i][j];
                positions[value] = new int[]{i, j};
            }
        }

        int[] rows = new int[m];
        int[] lines = new int[n];

        int count = 0;
        for (int i : arr) {
            int[] position = positions[i];
            int row = ++rows[position[0]];
            int line = ++lines[position[1]];

            if (row == n) {
                break;
            }

            if (line == m) {
                break;
            }
            count++;
        }

        return count;
    }
}