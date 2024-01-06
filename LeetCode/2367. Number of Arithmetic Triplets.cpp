class Solution {
public:
    int arithmeticTriplets(vector<int>& nums, int diff) {
        int count = 0;
        unordered_set<int> data;

        for(int num : nums) {
            data.insert(num);
        }

        for(int num : data) {
            if(data.count(num - diff) && data.count(num + diff)) {
                count += 1;
            }
        }

        return count;
    }
};
