class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int diagonal = Integer.MIN_VALUE, square = Integer.MIN_VALUE;
        for (int[] dimension : dimensions) {
            int length = dimension[0];
            int width = dimension[1];
            int currDiagonal = (length * length) + (width * width);
            if (currDiagonal > diagonal) {
                diagonal = currDiagonal;
                square = length * width;
            } else if (currDiagonal == diagonal) {
                square = Math.max(square, length * width);
            }
        }

        return square;
    }
}