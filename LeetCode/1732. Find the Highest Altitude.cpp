class Solution {
public:
    int largestAltitude(vector<int>& gain) {
        vector<int> prefixSum(gain.size() + 1);
        prefixSum[0] = 0;
        int max = prefixSum[0];

        for (int i = 0; i < gain.size(); i ++) {
            prefixSum[i + 1] = gain[i] + prefixSum[i];
            if(prefixSum[i + 1] > max) {
                max = prefixSum[i + 1];
            }
        }

        return max;
    }
};
