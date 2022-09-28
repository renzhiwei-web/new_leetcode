package stringclass;

import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {
    public boolean CheckPermutation(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] ss = s1.toCharArray();
        for (char s : ss) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        char[] ss2 = s2.toCharArray();
        for (char ch : ss2) {
            if (!map.containsKey(ch)) {
                return false;
            }
            map.put(ch, map.get(ch) - 1);
        }

        for (char ch : map.keySet()) {
            if (map.get(ch) != 0) {
                return false;
            }
        }

        return true;
    }

}
