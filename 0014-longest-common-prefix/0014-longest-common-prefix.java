class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }

        String[] strings = Arrays.stream(strs)
                .sorted(Comparator.comparingInt(String::length))
                .toArray(String[]::new);
        String stdStr = strings[0];
        String result = "";

        int stdLength = stdStr.length();
        for (int i = 0; i <= stdLength; i++) {
            int finalI = i;
            Set<String> set = Arrays.stream(strs)
                    .map(s -> s.substring(0, finalI))
                    .collect(Collectors.toSet());
            if (set.size() == 1) {
                result = String.valueOf(set.toArray()[0]);
            } else {
                break;
            }
        }

        return result;
    }
}