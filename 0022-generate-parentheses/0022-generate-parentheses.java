class Solution {
    public List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        parenthesisDeepDive(new StringBuilder(), n, n);
        return result;
    }

    private void parenthesisDeepDive(StringBuilder sb, int openCnt, int closeCnt) {
        if (closeCnt == 0) {
            result.add(sb.toString());
        }

        if (openCnt > 0) {
            sb.append("(");
            parenthesisDeepDive(sb, openCnt - 1, closeCnt);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (closeCnt > 0 && openCnt < closeCnt) {
            sb.append(")");
            parenthesisDeepDive(sb, openCnt, closeCnt - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}