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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int[] arr1 = getArrToNode(l1);
        int[] arr2 = getArrToNode(l2);

        List<Integer> sumArrays = sumArrays(arr1, arr2);

        return getNodeToList(sumArrays);
    }

    private ListNode getNodeToList(List<Integer> sumArrays) {
        ListNode currNode = new ListNode(sumArrays.get(sumArrays.size() - 1));
        for (int i = sumArrays.size() - 2; i >= 0; i--) {
            ListNode prevNode = new ListNode(sumArrays.get(i), currNode);
            currNode = prevNode;
        }
        return currNode;
    }

    private int[] getArrToNode(ListNode listNode) {
        int[] answer = new int[100];
        for (int i = 0; i < 100; i++) {
            answer[i] = -1;
        }
        int index = 0;
        while (listNode != null) {
            answer[index] = listNode.val;
            listNode = listNode.next;
            index++;
        }
        return answer;
    }

    private List<Integer> sumArrays(int[] arr1, int[] arr2) {
        int digit = 0;
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int i1 = arr1[i] == -1 ? 0 : arr1[i];
            int i2 = arr2[i] == -1 ? 0 : arr2[i];
            if (arr1[i] == -1 && arr2[i] == -1 && digit == 0) {
                break;
            }
            int num = i1 + i2 + digit;
            if (num >= 10) {
                digit = 1;
            } else {
                digit = 0;
            }

            answer.add(num % 10);
        }

        return answer;
    }
}