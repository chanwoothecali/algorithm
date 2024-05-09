class Solution {
    public int myAtoi(String s) {
        String trim = s.trim();
        boolean isFirstNumber = false;
        boolean isDecideSign = false;
        long value = 0l;
        boolean isMinus = false;

        for (int i = 0; i < trim.length(); i++) {
            char c = trim.charAt(i);
            if (c == '-' || c == '+') {
                if (isFirstNumber) break;
                if (isDecideSign) break;
                isDecideSign = true;
                if (c == '-') isMinus = true;
            }

            if (c >= 48 && c <= 57) {
                value *= 10;
                if (isMinus) {
                    value -= Character.getNumericValue(c);
                } else {
                    value += Character.getNumericValue(c);
                }

                if (value >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else if (value <= Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
                if (i == 0) isFirstNumber = true;
            } else if (c == 45 || c == 43) {
            } else {
                break;
            }
        }

        return (int) value;
    }
}