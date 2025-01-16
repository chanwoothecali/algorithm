class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int xor1 = Arrays.stream(nums1).reduce((a, b) -> a ^ b).getAsInt();
        int xor2 = Arrays.stream(nums2).reduce((a, b) -> a ^ b).getAsInt();

        return (nums2.length % 2 * xor1) ^ (nums1.length % 2 * xor2);
    }
}