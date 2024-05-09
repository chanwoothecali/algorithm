class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long result = 0;
        long low = 1;
        long high = Long.MAX_VALUE;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            boolean pass = isValid(time, mid, totalTrips);

            if (pass) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    public boolean isValid(int[] time, long mid, int totalTrips){
        long finish = 0;
        for (int each : time) {
            finish += mid / each;
            if (finish >= totalTrips) { return true; }
        }
        return false;
    }
}