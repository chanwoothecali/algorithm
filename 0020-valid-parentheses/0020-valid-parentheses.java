class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if ("({[".indexOf(aChar) > -1) {
                stack.push(aChar);
            }
            if (aChar == ')' && (stack.size() == 0 || stack.pop() != '(')) {
                return false;
            }
            if (aChar == '}' && (stack.size() == 0 || stack.pop() != '{')) {
                return false;
            }
            if (aChar == ']' && (stack.size() == 0 || stack.pop() != '[')) {
                return false;
            }
        }
        return stack.size() == 0;
    }
}