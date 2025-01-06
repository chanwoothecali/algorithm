class Solution {
    private final String vowels = "aeiou";
    private boolean qualifyWords[];
    private int rightQualifyWordsCount[];

    public int[] vowelStrings(String[] words, int[][] queries) {
        qualifyWords = new boolean[words.length];
        rightQualifyWordsCount = new int[words.length];
        int length = queries.length;
        int result[] = new int[length];
        int qualifyWordsCount = 0;

        int index = 0;
        for (String word : words) {
            char beginWord = word.charAt(0);
            char endWord = word.charAt(word.length() - 1);
            boolean isQualifyWord = vowels.indexOf(beginWord) != -1 && vowels.indexOf(endWord) != -1;
            qualifyWords[index++] = isQualifyWord;
            if (isQualifyWord) qualifyWordsCount++;
        }

        rightQualifyWordsCount[0] = qualifyWordsCount;
        for (int i = 1; i < words.length; i++) {
            if (qualifyWords[i - 1]) {
                qualifyWordsCount--;
            }
            rightQualifyWordsCount[i] = qualifyWordsCount;
        }

        for (int i = 0; i < length; i++) {
            int[] query = queries[i];
            int left = query[0];
            int right = query[1];
            result[i] = rightQualifyWordsCount[left] - rightQualifyWordsCount[right];
            if (qualifyWords[right]) result[i]++;
        }

        return result;
    }
}