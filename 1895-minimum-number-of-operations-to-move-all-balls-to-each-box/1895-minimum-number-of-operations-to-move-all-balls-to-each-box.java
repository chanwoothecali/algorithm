class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];
        int right = 0, left = 0;

        int moves = 0;
        // 1번 상자로 옮기는 횟수 먼저 구하기
        for (int i = 0; i < n; i++) {
            char c = boxes.charAt(i);
            if (c == '1') {
                moves += i;
                right++;
            }
        }
        answer[0] = moves;

        // 각 시점 별로 이동 횟수 구하기
        for (int i = 1; i < n; i++) {
            char previousWord = boxes.charAt(i - 1);

            if (previousWord == '1') {
                left++;
                right--;
            }
            moves = moves - right + left;
            answer[i] = moves;
        }

        return answer;
    }
}