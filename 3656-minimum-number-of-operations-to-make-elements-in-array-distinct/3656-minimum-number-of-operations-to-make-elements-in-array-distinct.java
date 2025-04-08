class Solution {
    public int minimumOperations(int[] nums) {
        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());

        int count = 0;
        while (!numsList.isEmpty()) {
            if (isDistinct(numsList)) {
                break;
            }
            numsList = cutList(numsList);
            count++;
        }

        return count;
    }

    private boolean isDistinct(List<Integer> nums) {
        return nums.size() == nums.stream().collect(Collectors.toSet()).size();
    }

    private List<Integer> cutList(List<Integer> nums) {
        int size = nums.size();
        if (size <= 3) {
            return new ArrayList<>();
        }

        return nums.subList(3, size);
    }
}