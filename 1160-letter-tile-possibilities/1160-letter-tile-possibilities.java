class Solution {
    public int numTilePossibilities(String tiles) {
        int[] alphabet = new int[26];
        char[] charArray = tiles.toCharArray();
        for (char c : charArray) {
            alphabet[c - 'A']++;
        }

        return dfs(alphabet);
    }

    private int dfs(int[] alphabet) {
        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (alphabet[i] == 0) {
                continue;
            }

            --alphabet[i];
            count += 1 + dfs(alphabet);
            ++alphabet[i];
        }

        return count;
    }
}