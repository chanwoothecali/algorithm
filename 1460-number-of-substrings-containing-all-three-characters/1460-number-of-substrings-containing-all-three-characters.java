class Solution {
    public int numberOfSubstrings(String s) {
        int answer = 0;
        int[] count = new int[3];
        char[] charArray = s.toCharArray();
        int l = 0;
        for (char c : charArray) {
            count[c - 'a']++;
            while (isAbc(count)) {
                --count[charArray[l++] - 'a'];
            }
            answer += l;
        }

        return answer;
    }

    private boolean isAbc(int[] count) {
        return count[0] > 0 && count[1] > 0 && count[2] > 0;
    }
}