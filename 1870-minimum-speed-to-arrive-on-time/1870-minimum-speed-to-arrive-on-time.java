class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        if (hour <= dist.length - 1) return -1;  // check if it is possible to be on time

        int low = 1, high = (int) 1e7;  // possible range of speed
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (check(dist, hour, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean check(int[] dist, double hour, int speed) {
        double total = 0;
        for (int i = 0; i < dist.length; i++) {
            double time = (double)dist[i] / speed;
            if (i < dist.length - 1) {
                total += Math.ceil(time);  // the train can only depart at an integer hour
            } else {
                total += time;  // for the last train, it can depart immediately
            }
        }
        return total <= hour;
    }
}