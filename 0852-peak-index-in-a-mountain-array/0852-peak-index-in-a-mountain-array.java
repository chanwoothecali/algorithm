class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int result = 0;
        int length = arr.length;
        
        int prev = arr[0];
        for (int i = 1; i < length; i++) {
            int curr = arr[i];
            if (prev < curr) {
                prev = curr;
                result = i;
                continue;
            }
            break;
        }
        
        return result;
    }
}