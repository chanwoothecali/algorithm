/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
    public ListNode detectCycle(ListNode head) {
        ListNode curr = head;
        Set<ListNode> nodes = new HashSet<>();
        while (curr != null) {
            if (nodes.contains(curr)) {
                return curr;
            }
            nodes.add(curr);
            curr = curr.next;
        }

        return null;
    }
}