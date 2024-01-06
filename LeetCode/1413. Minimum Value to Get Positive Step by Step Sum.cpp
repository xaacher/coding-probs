class Solution {
public:
    int minStartValue(vector<int>& nums) {
        vector<int> prefixSum(nums.size());

        int startValue = max(1 - nums[0], 1);
        prefixSum[0] = nums[0] + startValue;
        int minValue = prefixSum[0];
        for(int i = 1; i < nums.size(); i ++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
            if(prefixSum[i] < minValue) {
                minValue = prefixSum[i];
            }
        }

        if(minValue < 1) {
            return startValue + (1 - minValue);
        }

        return startValue;
    }
};
