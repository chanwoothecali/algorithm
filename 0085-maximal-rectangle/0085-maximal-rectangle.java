import java.util.*;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] height = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0) {
                        height[i][j] = 1;
                        continue;
                    }
                    height[i][j] = height[i - 1][j] + 1;
                }
            }
        }

        int maxArea = 0;
        for (int i = 0; i < row; i++) {
            maxArea = Math.max(maxArea, maxAreaInHist(height[i]));
        }

        return maxArea;
    }

    public int maxAreaInHist(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;

        for (int i = 0; i <= height.length; i++) {
            int cur = i == height.length ? -1 : height[i];
            while (!stack.isEmpty() && cur < height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : (i - stack.peek() - 1);
                max = Math.max(max, w * h);
            }
            stack.push(i);
        }

        return max;
    }
}