class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        String[] arr = new String[numRows];
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            arr[i] = "";
        }

        int cycle = 2 * numRows - 2;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = i % cycle;
            if (idx >= numRows) {
                arr[cycle - idx] += c;
                System.out.println("idx = " + (cycle - idx));
            } else {
                arr[idx] += c;
                System.out.println("idx = " + idx);
            }
        }

        for (String s1 : arr) {
            result.append(s1);
        }
        return result.toString();
    }
}