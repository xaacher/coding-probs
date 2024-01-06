class Solution {
public:
    bool isCovered(vector<vector<int>>& ranges, int left, int right) {
        vector<int> coverred(51);

        for(int i = 0; i < ranges.size(); i ++) {
            int start = max(ranges[i][0], left);
            int end = min(ranges[i][1], right);
            for(int j = start; j <= end; j ++) {
                coverred[j] += 1;
            }
        }

        for(int i = left; i <= right; i++) {
            if(coverred[i] == 0) {
                return false;
            }
        }

        return true;
    }
};
