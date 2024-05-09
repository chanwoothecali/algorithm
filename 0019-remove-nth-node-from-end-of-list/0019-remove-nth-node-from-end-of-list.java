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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode currNode = head, prevNode = null;
        int nodeLength = getNodeLength(head);
        int target = nodeLength - n + 1;
        int index = 1;
        while (currNode != null) {
            if (index == target) {
                if (prevNode != null) {
                    prevNode.next = currNode.next;
                }
                if (n == nodeLength) {
                    head = currNode.next;
                }
                break;
            }
            prevNode = currNode;
            currNode = currNode.next;
            index++;
        }
        return head;
    }

    private int getNodeLength(ListNode head) {
        ListNode curr = head;
        int index = 0;
        while (curr != null) {
            index++;
            curr = curr.next;
        }
        return index;
    }
}