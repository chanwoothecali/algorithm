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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newList = null, nextNode, currNode = null;
        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                if (list1.val >= list2.val) {
                    if (newList == null) {
                        currNode = new ListNode(list2.val);
                        newList = currNode;
                    } else {
                        nextNode = new ListNode(list2.val);
                        currNode.next = nextNode;
                        currNode = nextNode;
                    }
                    list2 = list2.next;
                } else {
                    if (newList == null) {
                        currNode = new ListNode(list1.val);
                        newList = currNode;
                    } else {
                        nextNode = new ListNode(list1.val);
                        currNode.next = nextNode;
                        currNode = nextNode;
                    }
                    list1 = list1.next;
                }
            } else if (list1 != null) {
                if (newList == null) {
                    return list1;
                } else {
                    currNode.next = list1;
                    break;
                }
            } else if (list2 != null) {
                if (newList == null) {
                    return list2;
                } else {
                    currNode.next = list2;
                    break;
                }
            }
        }
        return newList;
    }
}