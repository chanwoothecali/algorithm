class Solution {
    public int countLargestGroup(int n) {
        int answer = Integer.MIN_VALUE;
        Map<Integer, Integer> numbers = new HashMap<>();
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int sumDigits = sumDigits(i);
            int count = numbers.getOrDefault(sumDigits, 0) + 1;
            numbers.put(sumDigits, count);
            counts.merge(count, 1, Integer::sum);
        }

        List<Integer> list = new ArrayList<>(counts.keySet());
        Collections.sort(list);
        int last = list.getLast();

        return counts.get(last);
    }

    private int sumDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}