class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        final int length = words.length;
        List<String> a = new ArrayList<>();
        List<String> b = new ArrayList<>();
        int aFlag = 0, bFlag = 1;
        for (int i = 0; i < length; i++) {
            String word = words[i];
            int group = groups[i];
            if (aFlag == group) {
                a.add(word);
                aFlag = Math.abs(aFlag - 1);
            }

            if (bFlag == group) {
                b.add(word);
                bFlag = Math.abs(bFlag - 1);
            }
        }

        if (a.size() > b.size()) {
            return a;
        } else {
            return b;
        }
    }
}