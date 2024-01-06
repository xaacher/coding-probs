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
    public ListNode middleNode(ListNode head) {
        int count = 1;
        int currentMidIndex = 0;
        ListNode nextNode = head;
        ListNode midNode = head;
        while(nextNode.next != null) {
            System.out.println(nextNode.val);
            nextNode = nextNode.next;
            count ++;


            if(currentMidIndex + 1 == count / 2) {
                midNode = midNode.next;
                currentMidIndex ++;
            }
        }

        return (currentMidIndex + 1 == count / 2) ? midNode.next : midNode;

    }
}
