class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        if (x < 10) {
            return true;
        }

        String[] split = String.valueOf(x).split("");
        int length = split.length;
        for (int index = 0; index < length / 2; index++) {
            int opposite = length - index - 1;
            if (!split[index].equals(split[opposite])) {
                return false;
            }
        }

        return true;
    }
}