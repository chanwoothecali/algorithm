class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        List<int[]> list = new ArrayList();
        int length = meetings.length;
        int index = 0;
        int prevStart = meetings[0][0], prevEnd = meetings[0][1];
        while (++index < length) {
            int currStart = meetings[index][0], currEnd = meetings[index][1];
            if (currStart >= prevStart && currStart <= prevEnd) {
                if (currEnd > prevEnd) {
                    prevEnd = currEnd;
                }
                continue;
            }
            list.add(new int[]{prevStart, prevEnd});
            prevStart = currStart;
            prevEnd = currEnd;
        }
        list.add(new int[]{prevStart, prevEnd});
        int count = days;
        for (int[] ints : list) {
            count -= ints[1] - ints[0] + 1;
        }

        return count;
    }
}