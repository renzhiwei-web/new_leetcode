package stringclass;

import java.util.HashSet;
import java.util.Set;

public class CheckIfTheSentenceIsPangram {
    // leetcode 1832 simple 2022/12/13
    // 首先很容易想到使用额外的数据结构来实现
    // 这个测试一下在数据量不大的情况下，数组的性能优于集合
    public boolean checkIfPangram1(String sentence) {
        char[] cs = sentence.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char ch :
                cs) {
            set.add(ch);
        }
        return set.size() == 26;
    }

    public boolean checkIfPangram2(String sentence) {
        int[] set = new int[26];
        for (int i = 0; i < sentence.length(); i++) {
            set[sentence.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (set[i] == 0){
                return false;
            }
        }
        return true;
    }
    // 可以使用二进制来表示状态
    public boolean checkIfPangram(String sentence) {
        int state = 0;
        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            state |= 1 << (ch - 'a');
        }
        return state == (1 << 26) - 1;
    }
}
