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
    bool isPalindrome(ListNode* head) {
        int count = 0;
        int mid = 0;
        unordered_map<int, int> data;
        while(head != NULL) {
            mid = max(count / 2, mid);
            data.insert({count, head -> val});
            head = head -> next;
            count ++;
        }

        cout << mid << endl;
        for(int i = 0; i <= mid; i++){
            if(data[i] != data[count - 1]) {
                return false;
            }
            count --;
        }

        return true;
    }
};
