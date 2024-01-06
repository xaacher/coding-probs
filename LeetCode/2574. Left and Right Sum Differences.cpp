class Solution {
public:
    // TC: O(n)
    // SC: O(n)
    vector<int> leftRightDifference(vector<int>& nums) {
        vector<int> result(nums.size());
        vector<int> prefixLeft(nums.size());
        prefixLeft[0] = 0;

        vector<int> prefixRight(nums.size());
        int prefixRightIndex = nums.size() - 1;
        prefixRight[prefixRightIndex] = 0;
        for(int i = 1; i < nums.size(); i++) {
            prefixLeft[i] = nums[i - 1] + prefixLeft[i - 1];
            prefixRight[prefixRightIndex -1] = prefixRight[prefixRightIndex] + nums[prefixRightIndex];
            prefixRightIndex --;
        }


        for(int i = 0; i < nums.size(); i++) {
            result[i] = abs(prefixLeft[i] - prefixRight[i]);
        }

        return result;
    }
};
