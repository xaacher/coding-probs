class Solution {
   public void moveZeroes(int[] nums) {
        int[] temp = nums.clone();
        int index = 0;
        int lastNormalIdx = 0;
        for (int i : temp) {
            if (i != 0) {
                nums[index++] = i;
                lastNormalIdx = index;
            }
        }

       for(int i = lastNormalIdx; i < nums.length; i ++) {
           nums[i] = 0;
       }
    }
}
