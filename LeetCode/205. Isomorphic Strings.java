class Solution {
     public boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        if (s.length() != t.length()) {
            return false;
        }

        // title
        // paper
        int index = 2;
        StringBuilder sResult = new StringBuilder("1");
        StringBuilder tResult = new StringBuilder("1");
        sMap.put(s.charAt(0), 1);
        tMap.put(t.charAt(0), 1);
        for (int i = 1; i < s.length(); i++) {
            int temp1 = sMap.getOrDefault(s.charAt(i), 0);
            if (temp1 == 0) {
                sResult.append(index);
                sMap.put(s.charAt(i), index);
            } else {
                sResult.append(temp1);
            }

            int temp2 = tMap.getOrDefault(t.charAt(i), 0);
            if (temp2 == 0) {
                tResult.append(index);
                tMap.put(t.charAt(i), index);
            } else {
                tResult.append(temp2);
            }

            index++;
        }
        return sResult.toString().equals(tResult.toString());
    }
}
