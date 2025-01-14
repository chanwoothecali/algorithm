class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int length = A.length;
        int[] C = new int[length];
        Set<Integer> set = new HashSet<>();
        int count = 0;

        for (int i = 0; i < length; i++) {
            int a = A[i];
            int b = B[i];
            if (!set.add(a)) count++;
            if (!set.add(b)) count++;
            C[i] = count;
        }

        return C;
    }
}