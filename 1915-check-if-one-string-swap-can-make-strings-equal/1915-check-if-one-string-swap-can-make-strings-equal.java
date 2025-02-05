class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        
        final int len = s1.length();
        char a1 = 'A', a2 = 'A', b1 = 'A', b2 = 'A';
        int count = 0;
        for (int i = 0; i < len; i++) {
            char sc1 = s1.charAt(i);
            char sc2 = s2.charAt(i);
            if (sc1 == sc2) {
                continue;
            }
            
            if (++count > 2) {
                return false;
            }

            if (count == 1) {
                a1 = sc1;
                b1 = sc2;
            } else if (count == 2) {
                a2 = sc1;
                b2 = sc2;
            }
        }

        if (count == 1) {
            return false;
        }

        if (a1 == b2 && a2 == b1) {
            return true;
        }

        return false;
    }
}