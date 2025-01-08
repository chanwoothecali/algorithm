class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;

        int length = words.length;
        for (int i = length - 1; i > 0; i--) {
            String word = words[i];
            for (int j = i - 1; j >= 0; j--) {
                String fix = words[j];
                if (isPrefixAndSuffix(word, fix)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isPrefixAndSuffix(String str1, String str2) {
        return str1.startsWith(str2) && str1.endsWith(str2);
    }
}