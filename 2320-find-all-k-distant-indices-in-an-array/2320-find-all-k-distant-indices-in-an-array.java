class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> indices = new ArrayList<>();
        List<Integer> keyIndexes = new ArrayList<>();

        final int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == key) {
                keyIndexes.add(i);
            }
        }

        for (int i = 0; i < len; i++) {
            for (Integer keyIndex : keyIndexes) {
                if (Math.abs(i - keyIndex) > k) {
                    continue;
                }

                indices.add(i);
                break;
            }
        }

        return indices;
    }
}