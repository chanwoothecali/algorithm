class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> results = new ArrayList<>();
        for (int num : nums) {
            if (num < pivot) {
                results.add(num);
            }
        }

        for (int num : nums) {
            if (num == pivot) {
                results.add(num);
            }
        }

        for (int num : nums) {
            if (num > pivot) {
                results.add(num);
            }
        }

        return results.stream().mapToInt(Integer::intValue).toArray();
    }
}