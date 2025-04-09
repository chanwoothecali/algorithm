class Solution {
    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int min = nums[0];
        if (min < k) {
            return -1;
        }

        Set<Integer> set = Arrays.stream(nums).mapToObj(i -> i).collect(Collectors.toSet());
        int size = set.size();

        return min == k ? size - 1 : size;
    }
}