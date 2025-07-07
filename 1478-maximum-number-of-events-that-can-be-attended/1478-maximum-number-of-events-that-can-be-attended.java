class Solution {
    public int maxEvents(int[][] events) {
        // 1. 시작일 기준 정렬
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        // 2. 우선순위 큐 (종료일 기준)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int day = 1, i = 0, res = 0;

        // 3. 전체 가능한 최대 날짜를 계산
        int n = events.length;
        int lastDay = 0;
        for (int[] e : events) {
            lastDay = Math.max(lastDay, e[1]);
        }

        // 4. 하루씩 순회
        while (day <= lastDay) {
            // 오늘 시작하는 이벤트들 추가
            while (i < n && events[i][0] == day) {
                pq.offer(events[i][1]);
                i++;
            }

            // 오늘 참석 못하는 이벤트 제거
            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }

            // 오늘 참석할 이벤트 하나 선택
            if (!pq.isEmpty()) {
                pq.poll();
                res++;
            }

            day++;
        }

        return res;
    }
}