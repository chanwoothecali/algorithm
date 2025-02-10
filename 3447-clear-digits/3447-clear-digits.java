class Solution {
    public String clearDigits(String s) {
        final int len = s.length();
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.add(charArray[0]);
        for (int i = 1; i < len; i++) {
            char curr = charArray[i];
            if (stack.empty()) {
                stack.push(curr);
                continue;
            }

            char prev = stack.pop();
            if (isDigit(curr) && !isDigit(prev)) {
                continue;
            }

            stack.push(prev);
            stack.push(curr);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    private boolean isDigit(char c) {
        return c >= 48 && c <= 57;
    }
}