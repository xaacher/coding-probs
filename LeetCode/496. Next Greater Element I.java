class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[10001];
        Deque<Integer> candidateFirstGreater = new ArrayDeque<>();
        // y tuong: su dung mot stack de luu candidateFirstGreater
        for (int i = nums2.length - 1; i >= 0; i--) {
            if (candidateFirstGreater.isEmpty()) {
                    result[nums2[i]] = -1;
                    candidateFirstGreater.offerFirst(nums2[i]);
                } else {
                     while (!candidateFirstGreater.isEmpty() && candidateFirstGreater.peekFirst() < nums2[i]) {
                        candidateFirstGreater.removeFirst();
                    }

                    result[nums2[i]] = candidateFirstGreater.isEmpty() ? -1 : candidateFirstGreater.peekFirst();
                    candidateFirstGreater.offerFirst(nums2[i]);
                }
            }

        int[] finalResult = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            finalResult[i] = result[nums1[i]];
        }

        return finalResult;
    }
}
