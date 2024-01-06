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
        Set<ListNode> check = new HashSet<>();
        while(head != null) {
            if(check.contains(head)) {
                return head;
            }

            check.add(head);
            head = head.next;
        }

        return null;
    }
}
