class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();

        int[] countB = new int[26];
        for (String s : words2) {
            int[] temp = count(s);
            for (int i = 0; i < 26; i++) {
                countB[i] = Math.max(countB[i], temp[i]);
            }
        }

        for (String s : words1) {
            if (isSubset(s, countB)) {
                result.add(s);
            }
        }

        return result;
    }

    private int[] count(String word) {
        int[] temp = new int[26];
        word.chars().forEach(c -> temp[c - 'a']++);
        return temp;
    }

    private boolean isSubset(String a, int[] countB) {
        int[] countA = count(a);
        for (int i = 0; i < 26; i++) {
            if (countA[i] - countB[i] < 0) {
                return false;
            }
        }

        return true;
    }
}