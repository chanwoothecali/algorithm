class Solution {
    public boolean checkPowersOfThree(int n) {
        int[] xs = new int[15];
        int x = 1, y = 3;
        while (n >= 3) {
            if (y * 3 <= n) {
                ++x;
                y *= 3;
                continue;
            }

            if (xs[x] == 1) {
                return false;
            }
            xs[x] = 1;
            x = 1;
            n -= y;
            y = 3;
        }

        return n != 2;
    }
}