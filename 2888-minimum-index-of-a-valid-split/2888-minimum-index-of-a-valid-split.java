class Solution {
    public int minimumIndex(List<Integer> nums) {
        final int len = nums.size();
        int dominant = getDominant(nums);

        int count = 0, size = 0;
        for (int i = 0; i < len; i++) {
            Integer value = nums.get(i);
            if (value == dominant) {
                count++;
            }

            if (count * 2 > i + 1) {
                size = i;
                break;
            }
        }

        if (size == len) {
            return -1;
        }

        List<Integer> subList = nums.subList(size + 1, len);
        count = 0;
        int subLen = subList.size();
        for (int i = 0; i < subLen; i++) {
            Integer value = subList.get(i);
            if (value == dominant) {
                count++;
            }
        }

        if (count * 2 > subLen) {
            return size;
        }

        return -1;
    }

    private int getDominant(List<Integer> nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        int maxCount = Integer.MIN_VALUE;
        int dominant = 0;
        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            Integer value = map.get(key);
            maxCount = Math.max(maxCount, value);
            if (maxCount == value) {
                dominant = key;
            }
        }

        return dominant;
    }
}