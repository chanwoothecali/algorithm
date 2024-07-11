class Solution {
    public String reverseParentheses(String s) {
        int length = s.length();
        int[] pairIndex = new int[length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < length; ++i) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int j = stack.pop();
                pairIndex[i] = j;
                pairIndex[j] = i;
            }
        }

        StringBuilder result = new StringBuilder();
        int index = 0;
        int direction = 1;

        while (index < length) {
            if (s.charAt(index) == '(' || s.charAt(index) == ')') {
                index = pairIndex[index];
                direction = -direction;
            } else {
                result.append(s.charAt(index));
            }
            index += direction;
        }

        return result.toString();
    }
}