class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> list = new LinkedList<>();

        int i = num.length - 1, sum = k;

        while (i >= 0 || sum > 0) {
            if (i >= 0) sum += num[i];
            list.addFirst(sum % 10);
            sum /= 10;
            i--;
        }

        return list;
    }
}