/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> arrayList = new ArrayList<>();

        // merge
        for (ListNode list : lists) {
            while (list != null) {
                arrayList.add(list.val);
                list = list.next;
            }
        }

        if (arrayList.isEmpty()) {
            return null;
        }

        // sort
        Collections.sort(arrayList, Collections.reverseOrder());
        arrayList.stream().forEach(System.out::println);

        ListNode node = new ListNode(arrayList.get(0));
        final int len = arrayList.size();
        for (int i = 1; i < len; i++) {
            node = new ListNode(arrayList.get(i), node);
        }

        return node;
    }
}