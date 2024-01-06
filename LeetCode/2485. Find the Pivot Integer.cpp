class Solution {
public:
    int pivotInteger(int n) {
        if(n ==1) {
            return 1;
        }
        vector<int> prefixSumLeft(n + 1);
        vector<int> prefixSumRight(n + 1);

        int prefixSumRightIndex = n - 1;
        prefixSumLeft[0] = 0;
        prefixSumRight[n] = n;
        for(int i = 1; i < n; i++) {
            prefixSumLeft[i] = i + prefixSumLeft[i - 1];
            prefixSumRight[prefixSumRightIndex] = prefixSumRight[prefixSumRightIndex + 1] + prefixSumRightIndex;
            prefixSumRightIndex --;
        }

        for(int i = 1; i <= n; i++) {
            if(prefixSumLeft[i] == prefixSumRight[i]) {
                return i;
            }
        }

        return -1;
    }
};
