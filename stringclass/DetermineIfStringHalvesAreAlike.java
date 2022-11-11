package stringclass;


import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class DetermineIfStringHalvesAreAlike {
    // leetcode 1704 simple 2022/11/11
    // 简单模拟即可
    public boolean halvesAreAlike(String s) {
        int len = s.length();
        String a = s.substring(0,len / 2);
        String b = s.substring(len / 2);
        int count = 0;
        for (int i = 0; i < len / 2; i++) {
            if (isVowels(a.charAt(i))){
                count++;
            }
            if (isVowels(b.charAt(i))){
                count--;
            }
        }
        return count == 0;
    }

    private static boolean isVowels(char ch){
        Set<Character> set = new HashSet<>();
        Collections.addAll(set,new Character[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'});
        return set.contains(ch);
    }
}
