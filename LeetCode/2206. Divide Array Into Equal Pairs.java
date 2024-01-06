class Solution {
    public boolean divideArray(int[] nums) {
        int pairNumber = nums.length / 2;
        int count = 0;
        Arrays.sort(nums);
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                count++;
                i += 2;
                j += 2;
            } else {
                i += 1;
                j += 1;
            }
        }
        return pairNumber == count;
    }
}
