class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.merge(num, 1, Integer::sum);
        }

        int maxLen = 0;
        for (int key : countMap.keySet()) {
            if (countMap.containsKey(key + 1)) {
                int currLen = countMap.get(key) + countMap.get(key + 1);
                maxLen = Math.max(maxLen, currLen);
            }
        }

        return maxLen;
    }
}