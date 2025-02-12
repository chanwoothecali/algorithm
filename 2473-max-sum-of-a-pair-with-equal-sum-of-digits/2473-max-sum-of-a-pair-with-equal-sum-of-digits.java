class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int num : nums) {
            map.merge(sumOfDigits(num), new ArrayList<>(List.of(num)), ((o, n) -> {
                o.add(num);
                return o;
            }));
        }

        int max = -1;
        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            List<Integer> integers = map.get(key);
            if (integers.size() < 2) {
                continue;
            }

            Collections.sort(integers, Collections.reverseOrder());
            max = Math.max(max, integers.get(0) + integers.get(1));
        }

        return max;
    }

    private Integer sumOfDigits(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}