class Solution {
    public String smallestNumber(String pattern) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        stack.add(1);

        char[] patternCharArray = pattern.toCharArray();
        for (char c : patternCharArray) {
            int max = stack.peek();
            if (c == 'I') {
                while (!stack.isEmpty()) {
                    max = Math.max(max, stack.peek());
                    sb.append(stack.pop());
                }
            }
            stack.push(max + 1);
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}