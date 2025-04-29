class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            max = Math.max(max, num);
            map.merge(num, 1, Integer::sum);
        }

        int maxCount = map.get(max);
        if (maxCount < k) {
            return 0;
        }

        long answer = 0l;
        int length = nums.length, prev = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            if (nums[i] == max) {
                queue.add(i);
            }

            if (queue.size() >= k) {
                int poll = queue.poll();
                answer += (long) (poll - prev + 1) * (length - i);
                prev = poll + 1;
            }
        }

        return answer;
    }
}