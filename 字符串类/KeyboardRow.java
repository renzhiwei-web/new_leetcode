package stringclass;

import java.util.ArrayList;
import java.util.List;

public class KeyboardRow {
	// leetcode 500 simple 2022/4/27
	// 简单模拟即可
	static String[] ss = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
    static int[] hash = new int[26];
    static {
        for (int i = 0; i < ss.length; i++) {
            for (char c : ss[i].toCharArray()) hash[c - 'a'] = i;
        }
    }
    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        out:for (String w : words) {//跳出多层循环
            int t = -1;
            for (char c : w.toCharArray()) {
                c = Character.toLowerCase(c);
                if (t == -1) t = hash[c - 'a'];
                else if (t != hash[c - 'a']) continue out;
            }
            list.add(w);
        }
        return list.toArray(new String[list.size()]);
    }
}
