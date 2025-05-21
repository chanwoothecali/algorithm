class Solution {
    public void setZeroes(int[][] matrix) {
        List<int[]> zeroIndexes = new ArrayList<>();

        int horizontalSize = matrix.length;
        int verticalSize = matrix[0].length;

        for (int i = 0; i < horizontalSize; i++) {
            for (int j = 0; j < verticalSize; j++) {
                if (matrix[i][j] == 0) {
                    zeroIndexes.add(new int[]{i, j});
                }
            }
        }

        for (int[] zeroIndex : zeroIndexes) {
            int horizontalIndex = zeroIndex[0];
            int verticalIndex = zeroIndex[1];

            for (int i = 0; i < horizontalSize; i++) {
                matrix[i][verticalIndex] = 0;
            }
            for (int i = 0; i < verticalSize; i++) {
                matrix[horizontalIndex][i] = 0;
            }
        }
    }
}