class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] sumArr = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, sumArr, 0, nums1.length);
        System.arraycopy(nums2, 0, sumArr, nums1.length, nums2.length);
        Arrays.sort(sumArr);

        int length = sumArr.length;
        if (length % 2 == 0) {
            int prev = (length / 2) - 1;
            int next = length / 2;
            return (sumArr[prev] + sumArr[next]) / 2.0;
        } else {
            return sumArr[length / 2];
        }
    }
}