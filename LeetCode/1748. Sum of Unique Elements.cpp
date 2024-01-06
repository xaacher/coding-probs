class Solution {
public:
    int sumOfUnique(vector<int>& nums) {
        int occurrences[101] = { 0 }; // all elements 0
        for (int i = 0; i < nums.size(); i++) {
            occurrences[nums[i]] = occurrences[nums[i]] + 1;
        }

        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            if(occurrences[nums[i]] == 1) {
                sum += nums[i];
            }
        }

        return sum;
    }
};
