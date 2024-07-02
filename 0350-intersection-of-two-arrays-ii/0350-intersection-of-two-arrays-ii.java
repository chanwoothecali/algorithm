class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();    

        for(int num : nums1) {
            int count = map.getOrDefault(num, 0);

            map.put(num, count + 1);
        }

        List<Integer> answer = new ArrayList<>();
        for(int num : nums2) {
            int count = map.getOrDefault(num, 0);

            if(count > 0) {
                answer.add(num);
                map.put(num, count - 1);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}