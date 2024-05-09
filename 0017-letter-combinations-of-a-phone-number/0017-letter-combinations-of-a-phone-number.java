class Solution {
    private List<String> combinations = new ArrayList<>();
    private Map<Character, String> letters = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    private String phoneDigits;

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return combinations;
        }
        phoneDigits = digits;
        StringBuilder sb = new StringBuilder();
        letterAppend(0, sb);
        return combinations;
    }

    private void letterAppend(int index, StringBuilder sb) {
        if (phoneDigits.length() == sb.length()) {
            combinations.add(sb.toString());
            return;
        }
        String possibleLetters = letters.get(phoneDigits.charAt(index));
        for (char letter : possibleLetters.toCharArray()) {
            sb.append(letter);
            letterAppend(index + 1, sb);
            sb.deleteCharAt(index);
        }
    }
}