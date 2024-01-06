 class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> sTemp = new HashMap<>();
        Map<Character, Integer> tTemp = new HashMap<>();
        int count;
        for (int i = 0; i < s.length(); i++) {
            count = sTemp.getOrDefault(s.charAt(i), 0) + 1;
            sTemp.put(s.charAt(i), count);

            count = tTemp.getOrDefault(t.charAt(i), 0) + 1;
            tTemp.put(t.charAt(i), count);
        }

        for (Character key : sTemp.keySet()) {
            if (!sTemp.getOrDefault(key, 0).equals(tTemp.getOrDefault(key, 0))) {
                return false;
            }
        }

        return true;
    }
}
