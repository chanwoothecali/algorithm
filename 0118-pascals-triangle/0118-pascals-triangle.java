class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            Integer[] row = new Integer[i + 1];
            Arrays.fill(row, 1);
            result.add(Arrays.asList(row));
        }

        for (int i = 2; i < numRows; i++) {
            for (int j = 1; j < result.get(i).size() - 1; j++) {
                result.get(i).set(j, result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
        }

        return result;
    }
}