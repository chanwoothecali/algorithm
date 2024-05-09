class Solution {
    public int reverse(int x) {
        long longX = x;
        if (longX == 0) {
            return 0;
        }
        boolean isMinus = false;
        if (longX < 0) {
            isMinus = true;
            longX *= -1;
        }
        String s = String.valueOf(longX);
        String[] strings = s.split("");
        List<String> stringList = Arrays.asList(strings);
        Collections.reverse(stringList);
        long result = 0;
        for (String digit : stringList) {
            result *= 10;
            result += Integer.parseInt(digit);
        }

        if (result - 1 > Integer.MAX_VALUE) {
            return 0;
        } else if (result == Integer.MAX_VALUE && isMinus) {
            return (int) (result *= -1);
        } else if (isMinus) {
            return (int) (result *= -1);
        }

        return (int) result;
    }
}