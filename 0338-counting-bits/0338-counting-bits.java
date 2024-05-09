class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            String binaryString = Integer.toBinaryString(i);
            result[i] = addDigits(binaryString);
        }

        return result;
    }

    private int addDigits(String str) {
        int result = 0;
        
        int length = str.length();
        for (int i = 0; i < length; i++) {
            result += Character.getNumericValue(str.charAt(i));
        }

        return result;
    }
}