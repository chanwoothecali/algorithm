class Solution {
    public int maxArea(int[] height) {
        int L = 0, R = height.length - 1, result = 0;
        while (L < R) {
            int leftHeight = height[L];
            int rightHeight = height[R];
            int bulk = (Math.min(leftHeight, rightHeight) * (R - L));
            result = Math.max(result, bulk);
            if (leftHeight < rightHeight) {
                L++;
            } else {
                R--;
            }
        }
        return result;
    }
}