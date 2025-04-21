class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        long figure = 0l;

        for (int difference : differences) {
            figure += difference;
            max = Math.max(max, figure);
            min = Math.min(min, figure);
        }
        long answer = upper - lower + 1;
        if (min < 0) {
            answer += min;
        }

        if (max > 0) {
            answer -= max;
        }


        return answer < 0 ? 0 : (int) answer;
    }
}