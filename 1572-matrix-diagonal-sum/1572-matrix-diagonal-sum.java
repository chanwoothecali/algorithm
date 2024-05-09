class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;

        int length = mat.length;
        for (int i = 0; i < length; i++) {
            sum += mat[i][i];
        }

        for (int i = 0, j = length - 1; i < length; i++, j--) {
            sum += mat[i][j];
        }

        if (length % 2 == 1) {
            int mid = length / 2;
            sum -= mat[mid][mid];
        }

        return sum;
    }
}