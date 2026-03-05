class Solution {
    public int minOperations(String s) {
        int length = s.length();
        char[] i1 = new char[length];
        char[] i2 = new char[length];
        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                i1[i] = '0';
                i2[i] = '1';
            } else {
                i1[i] = '1';
                i2[i] = '0';
            }
        }
        
        int a = 0, b = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c != i1[i]) {
                a++;
            }
            if (c != i2[i]) {
                b++;
            }
        }
        return Integer.min(a, b);
    }
}