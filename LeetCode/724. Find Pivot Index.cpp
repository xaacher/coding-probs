class Solution {
public:
    int pivotIndex(vector<int>& nums) {
        int size = nums.size();
        vector<int> prefixSumLeft(size);
        vector<int> prefixSumRight(size);

        int prefixSumRightIndex = size - 2;
        prefixSumLeft[0] = 0;
        prefixSumRight[size - 1] = 0;
        for(int i = 1; i < size; i++) {
            prefixSumLeft[i] = nums[i - 1] + prefixSumLeft[i - 1];
            prefixSumRight[prefixSumRightIndex] = prefixSumRight[prefixSumRightIndex + 1] + nums[prefixSumRightIndex + 1];
            prefixSumRightIndex --;
        }

        for(int i = 0; i < size; i++) {
            if(prefixSumLeft[i] == prefixSumRight[i]) {
                return i;
            }
        }

        return -1;
    }
};
