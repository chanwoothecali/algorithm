class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));

        int length = words.length;
        for (int i = 0; i < length; i++) {
            String a = words[i];
            for (int j = i + 1; j < length; j++) {
                String b = words[j];
                if (b.contains(a)) {
                    result.add(a);
                    break;
                }
            }
        }

        return result;
    }
}