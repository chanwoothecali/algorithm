class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new HashMap<>();

        int length = names.length;
        for (int i = 0; i < length; i++) {
            map.put(heights[i], names[i]);
        }

        ArrayList<Integer> keyList = new ArrayList<>(map.keySet());
        keyList.sort(Collections.reverseOrder());

        String[] sortedPeople = new String[length];
        for (int i = 0; i < length; i++) {
            sortedPeople[i] = map.get(keyList.get(i));
        }

        return sortedPeople;
    }
}