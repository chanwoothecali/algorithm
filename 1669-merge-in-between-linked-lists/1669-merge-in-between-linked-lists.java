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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = null, last = null;
        int i = 1;
        ListNode t = list1;
        while(t != null){
            if(i == a){
                head = t;
            }
            if(i == b + 1){
                last = t.next;
                break;
            }
            t = t.next;
            i++;
        }
        head.next = list2;
        while(head.next != null){
            head = head.next;
        }
        head.next = last;
        return list1;
    }
}