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
    public boolean hasCycle(ListNode head) {
        Map<ListNode, Integer> check = new HashMap<>();
        while(head != null) {
            if(check.containsKey(head)) {
                return true;
            }

            check.put(head, 1);
            head = head.next;
        }

        return false;
    }
}
