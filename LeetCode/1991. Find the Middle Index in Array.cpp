class Solution {
public:
    int findMiddleIndex(vector<int>& nums) {
        vector<int> prefixLeftSum(nums.size());
        vector<int> prefixRightSum(nums.size());

        prefixLeftSum[0] = nums[0];
        prefixRightSum[nums.size() - 1] = nums[nums.size() - 1];
        int rightIndex = nums.size() - 2;
        for(int i = 1; i < nums.size(); i ++) {
            prefixLeftSum[i] = prefixLeftSum[i - 1] + nums[i];
            prefixRightSum[rightIndex] = prefixRightSum[rightIndex + 1] + nums[rightIndex];
            rightIndex --;
        }

        for(int i = 0; i < nums.size(); i ++) {
            if(prefixLeftSum[i] == prefixRightSum[i]) {
                return i;
            }
        }

        return -1;
    }
};
