class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> verticalIndexes = new HashSet<>();
        Set<Integer> horizontalIndexes = new HashSet<>();

        int horizontalSize = matrix.length;
        int verticalSize = matrix[0].length;

        for (int i = 0; i < horizontalSize; i++) {
            for (int j = 0; j < verticalSize; j++) {
                if (matrix[i][j] == 0) {
                    horizontalIndexes.add(i);
                    verticalIndexes.add(j);
                }
            }
        }

        for (Integer horizontalIndex : horizontalIndexes) {
            for (int i = 0; i < verticalSize; i++) {
                matrix[horizontalIndex][i] = 0;
            }
        }

        for (Integer verticalIndex : verticalIndexes) {
            for (int i = 0; i < horizontalSize; i++) {
                matrix[i][verticalIndex] = 0;
            }
        }
    }
}