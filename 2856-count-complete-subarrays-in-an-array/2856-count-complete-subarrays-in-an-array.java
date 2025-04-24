class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        int size = map.keySet().size();
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        int length = nums.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            set.add(num);
            list.add(num);
            map.merge(num, -1, Integer::sum);
            while (set.size() == size) {
                count += length - i;
                int first = list.removeFirst();
                if (!list.contains(first)) {
                    set.remove(first);
                }
            }
        }

        return count;
    }
}