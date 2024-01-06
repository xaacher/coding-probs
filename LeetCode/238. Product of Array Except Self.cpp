class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        // 1 2 3 4 5 6 7
        // 1 1              2*3*4*5*6*7
        // 2 1              3*4*5*6*7
        // 3 1*2            4*5*6*7
        // 4 1*2*3          5*6*7
        // 5 1*2*3*4        6*7
        // 6 1*2*3*4*5      7
        // 7 1*2*3*4*5*6    1

        vector<int> prefixData(nums.size());
        vector<int>prefixReverseData(nums.size());
        prefixData[0] = 1;
        prefixReverseData[nums.size() - 1] = 1;
        int reverseDataIndex = nums.size() - 2;
        for(int i = 1; i < nums.size(); i++) {
           prefixData[i] = prefixData[i - 1] * nums[i - 1];
           prefixReverseData[reverseDataIndex] =  prefixReverseData[reverseDataIndex + 1] * nums[reverseDataIndex + 1];
           reverseDataIndex --;
        }

        vector<int> result(nums.size());
        for(int i = 0; i < nums.size(); i++) {
            result[i] = prefixData[i] * prefixReverseData[i];
        }

        return result;
    }
};
