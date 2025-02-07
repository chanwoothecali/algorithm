class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int[] ans = new int[queries.length];
        Map<Integer, Integer> ballToColor = new HashMap<>();
        Map<Integer, Integer> colorCount = new HashMap<>();

        final int len = queries.length;
        for (int i = 0; i < len; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];
            if (ballToColor.containsKey(ball)) {
                final int prevColor = ballToColor.get(ball);
                if (colorCount.merge(prevColor, -1, Integer::sum) == 0) {
                    colorCount.remove(prevColor);
                }
            }
            ballToColor.put(ball, color);
            colorCount.merge(color, 1, Integer::sum);
            ans[i] = colorCount.size();
        }

        return ans;
    }
}