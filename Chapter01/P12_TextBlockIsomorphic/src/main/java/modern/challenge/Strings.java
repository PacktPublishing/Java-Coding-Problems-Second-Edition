package modern.challenge;

import java.util.HashMap;
import java.util.Map;

public final class Strings {

    private Strings() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static boolean isIsomorphic(String s1, String s2) {

        if (s1 == null || s2 == null
                || s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        
        for (int i = 0; i < s1.length(); i++) {

            char chs1 = s1.charAt(i);
            char chs2 = s2.charAt(i);
                        
            if (map.containsKey(chs1)) {
                if (map.get(chs1) != chs2) {
                    return false;
                }
            } else {
                if (map.containsValue(chs2)) {
                    return false;
                }
                map.put(chs1, chs2);
            }
        }

        return true;
    }
}