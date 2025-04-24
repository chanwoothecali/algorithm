class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int size = set.size();
        set.clear();

        List<Integer> list = new ArrayList<>();
        int length = nums.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            set.add(num);
            list.add(num);
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