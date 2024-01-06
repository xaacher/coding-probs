class Solution {
public:
    int numberOfPoints(vector<vector<int>>& nums) {
        vector<int> parts(101);

        int count = 0;
        for(int i = 0; i < nums.size(); i ++) {
            int start = nums[i][0];
            int end = nums[i][1];
            for(int j = start; j <= end; j ++) {
                parts[j] += 1;
                if(parts[j] == 1) {
                    count ++;
                }
            }
        }

        return count;
    }
};
