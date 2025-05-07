class Solution {

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;

        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int time = cur[0], x = cur[1], y = cur[2];

            if (x == n - 1 && y == m - 1) return time;

            for (int[] d : directions) {
                int nx = x + d[0];
                int ny = y + d[1];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                int nextTime = Math.max(time, moveTime[nx][ny]) + 1;
                if (nextTime < dist[nx][ny]) {
                    dist[nx][ny] = nextTime;
                    pq.offer(new int[]{nextTime, nx, ny});
                }
            }
        }
        return -1;
    }
}