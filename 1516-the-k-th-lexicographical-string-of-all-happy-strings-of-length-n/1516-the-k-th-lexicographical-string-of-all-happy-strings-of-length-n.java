class Solution {
    private Character[] letters = new Character[]{'a', 'b', 'c'};
    List<String> happyStrings = new ArrayList<>();

    public String getHappyString(int n, int k) {

        StringBuilder sb = new StringBuilder();
        dfs(sb, n);
        if (happyStrings.size() < k) {
            return "";
        }
        Collections.sort(happyStrings);

        return happyStrings.get(k - 1);
    }

    private void dfs(StringBuilder word, int n) {
        int length = word.length();
        if (length == n) {
            happyStrings.add(word.toString());
            return;
        }

        for (int i = 0; i < 3; i++) {
            Character letter = letters[i];
            if (length == 0) {
                word.append(letter);
                dfs(word, n);
                word.deleteCharAt(length);
                continue;
            }

            char lastLetter = word.charAt(length - 1);
            if (lastLetter == letter) {
                continue;
            }
            word.append(letter);
            dfs(word, n);
            word.deleteCharAt(length);
        }
    }
}