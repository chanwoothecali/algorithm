class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        // 모든 쌍 비교
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (words[i].length() == words[j].length() &&
                        hammingDistance(words[i], words[j]) == 1 &&
                        groups[i] != groups[j]) {

                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                    }
                }
            }
        }

        // 최댓값 인덱스 찾기
        int maxIdx = 0;
        for (int i = 1; i < n; i++) {
            if (dp[i] > dp[maxIdx]) {
                maxIdx = i;
            }
        }

        // 결과 구성
        LinkedList<String> result = new LinkedList<>();
        while (maxIdx != -1) {
            result.addFirst(words[maxIdx]);
            maxIdx = prev[maxIdx];
        }

        return result;
    }

    // 해밍 거리 계산
    private int hammingDistance(String s1, String s2) {
        int dist = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                dist++;
            }
        }
        return dist;
    }
}