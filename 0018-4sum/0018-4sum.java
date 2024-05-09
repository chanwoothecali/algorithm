class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> resultSet = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int i1 = 0; i1 < length - 3; i1++) {
            if (i1 != 0 && nums[i1] == nums[i1 - 1]) {
                continue;
            }
            for (int i2 = i1 + 1; i2 < length - 2; i2++) {
                if (i2 != i1 + 1 && nums[i2] == nums[i2 - 1]) {
                    continue;
                }
                int left = i2 + 1, right = nums.length - 1;
                while (left < right) {
                    if (left != i2 + 1 && nums[left] == nums[left - 1]) {
                        left++;
                        continue;
                    }
                    if (right != nums.length - 1 && nums[right] == nums[right + 1]) {
                        right--;
                        continue;
                    }
                    long sum = (long) nums[i1] + (long) nums[i2] + (long) nums[left] + (long) nums[right];
                    if (sum == target) {
                        resultSet.add(List.of(nums[i1], nums[i2], nums[left], nums[right]));
                        left++;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return resultSet;
    }
}