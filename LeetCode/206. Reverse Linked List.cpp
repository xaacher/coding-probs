 /**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        ListNode *dummy = new ListNode();
        ListNode *after;
        while(head != NULL) {
            after = head -> next;
            head -> next = dummy -> next;
            dummy -> next = head;
            head = after;
        }

        return dummy -> next;
    }
};
