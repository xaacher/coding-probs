class Solution {
  public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }

        int index = 0;
        int innerIndex = 0;
        int tempIndex = 0;
        while (index < haystack.length() && tempIndex < haystack.length() && innerIndex < needle.length()) {
            innerIndex = (haystack.charAt(tempIndex) == needle.charAt(innerIndex)) ? innerIndex + 1 : 0;
            if (innerIndex == needle.length()) {
                return index;
            }

            if (innerIndex == 0) {
                index++;
                tempIndex = index;
            } else {
                tempIndex++;
            }
        }
        return -1;
    }
}
