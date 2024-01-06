class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> result;

        // [0,0,0,0]
        for (int i = 0; i < nums.size(); i ++) {
            int goal = 0 - nums[i];
            int leftPointer = i + 1;
            int rightPointer = nums.size() - 1;
            while(leftPointer < rightPointer) {
                if(nums[leftPointer] + nums[rightPointer] == goal) {
                    result.push_back({nums[i], nums[leftPointer], nums[rightPointer]});
                    while(leftPointer + 1 < nums.size()  && nums[leftPointer] == nums[leftPointer + 1]) {
                        leftPointer ++;
                    }

                    while(rightPointer - 1 > leftPointer && nums[rightPointer] == nums[rightPointer - 1]) {
                        rightPointer --;
                    }


                    leftPointer ++;
                    rightPointer --;

                    cout << i << " - " << leftPointer << " - " << rightPointer << endl;
                } else if(nums[leftPointer] + nums[rightPointer] > goal) {
                    rightPointer --;
                } else {
                    leftPointer ++;
                }
            }

            while(i + 1 < nums.size() - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
        }

        return result;
    }
};
