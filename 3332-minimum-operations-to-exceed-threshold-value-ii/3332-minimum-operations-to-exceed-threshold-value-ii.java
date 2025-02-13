class Solution {
    public int minOperations(int[] nums, int k) {
        Queue<Long> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer((long) num);
        }

        int count = 0;
        for (int i = 1; i <= k; i++) {
            long mostMin = queue.poll();
            if (mostMin >= k) {
                break;
            }
            long secondMin = queue.poll();
            long operate = mostMin * 2 + secondMin;
            queue.add(operate);
            count = i;
        }

        return count;
    }
}