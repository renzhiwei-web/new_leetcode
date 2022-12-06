package stringclass;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDifferentIntegersInAString {
    // leetcode 1805 simple 2022/12/6
    // 正则表达式的应用
    public int numDifferentIntegers(String word) {
        String[] digits = word.split("[a-z]+");
        Set<String> set = new HashSet<>();
        for (String str : digits) {
            if (str.length() > 0) {
                set.add(str.replaceAll("^0+",""));
            }
        }
        return set.size();
    }
}
