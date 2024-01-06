class Solution {
public:
    int countPairs(vector<int>& nums, int target) {
        int count = 0;
        for(int i = 0; i < nums.size() - 1; i ++) {
            int leftPointer = i;
            int rightPointer = nums.size() - 1;
            while(rightPointer > leftPointer) {
                if(nums[leftPointer] + nums[rightPointer] < target) {
                    count ++;
                }

                rightPointer --;
            }
        }

        return count;
    }
};
