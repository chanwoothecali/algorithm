class Solution {
    private final Character[] vowels = new Character[]{'a', 'e', 'i', 'o', 'u'};

    public boolean isValid(String word) {
        if (word == null || word.length() < 3) {
            return false;
        }

        boolean haveVowel = false, haveConsonant = false;
        String lowerCase = word.toLowerCase();
        char[] charArray = lowerCase.toCharArray();
        for (Character c : charArray) {
            boolean match = Arrays.stream(vowels).anyMatch(c::equals);
            int charInt = c;
            if (match) {
                haveVowel = true;
            } else if (charInt <= 122 && charInt >= 97) {
                haveConsonant = true;
            } else if (charInt > 57 || charInt < 48) {
                return false;
            }
        }

        return haveVowel && haveConsonant;
    }
}