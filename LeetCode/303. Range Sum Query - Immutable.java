class NumArray {
    int[] prefixSum;

    // -2, 0, 3(2), -5, 2, -1(5)
    /// [2,5]  3 + (-5) + 2 + (-1)
    public NumArray(int[] nums) {
        prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        for(int i = 1; i <= nums.length; i++) {
            prefixSum[i] = nums[i - 1] + prefixSum[i - 1];
        }

        nums = prefixSum;
    }

    int sumRange(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
