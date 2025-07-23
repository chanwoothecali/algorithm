class Solution {
    public int maximumGain(String s, int x, int y) {
        String sub1 = "", sub2 = "";
        int point1 = 0, point2 = 0;
        if (x > y) {
            sub1 = "ab";
            sub2 = "ba";
            point1 = x;
            point2 = y;
        } else {
            sub1 = "ba";
            sub2 = "ab";
            point1 = y;
            point2 = x;
        }

        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        int score = 0;
        for (char c : s.toCharArray()) {
            if (!stack1.isEmpty() && (stack1.peek() == sub1.charAt(0) && c == sub1.charAt(1))) {
                stack1.pop();
                score += point1;
            } else {
                stack1.push(c);
            }
        }

        for (char c : stack1) {
            if (!stack2.isEmpty() && (stack2.peek() == sub2.charAt(0) && c == sub2.charAt(1))) {
                stack2.pop();
                score += point2;
            } else {
                stack2.push(c);
            }
        }

        return score;
    }
}