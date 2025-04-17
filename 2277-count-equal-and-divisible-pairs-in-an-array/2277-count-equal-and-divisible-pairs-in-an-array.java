class Solution {
    public int countPairs(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(i);
        }
        int ans = 0;
        for (List<Integer> list : map.values()) {
            int size = list.size();
            if (size < 2) {
                continue;
            }
            for (int i = 0; i < size; i++) {
                Integer i1 = list.get(i);
                for (int j = i + 1; j < size; j++) {
                    Integer i2 = list.get(j);
                    if (i1 * i2 % k == 0) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }
}