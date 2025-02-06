class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        final int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int multiple = nums[i] * nums[j];
                map.put(multiple, map.getOrDefault(multiple, 0) + 1);
            }
        }

        Set<Integer> keySet = map.keySet();
        int result = 0;
        for (Integer key : keySet) {
            Integer i = map.get(key);
            System.out.println(key + ": " + i);
            result += i * (i - 1) / 2;
        }

        return result * 8;
    }
}