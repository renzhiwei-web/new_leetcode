package stringclass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAndReplacePattern {
	// leetcode 890 medium 2022/6/12
	// 难点是没有想到使用双映射表来解题
	// 哈希表也可以用来做映射
    public List<String> findAndReplacePattern(String[] words, String pattern) {
    	List<String> ans = new ArrayList<>();
    	// map记录具体的映射关系，vis记录那些字符已经被映射
    	int[] map = new int[26],vis = new int[26];
    	for(String s : words) {
    		// 每遍历一个单词就刷新一次映射表
    		Arrays.fill(map, -1);
    		Arrays.fill(vis, 0);
    		boolean ok = true;
    		for(int i = 0;i < pattern.length() && ok;i++) {
    			int c1 = s.charAt(i) - 'a',c2 = pattern.charAt(i) - 'a';
    			if (map[c1] == -1 && vis[c2] == 0) {
    				// 若是当前字符的初次映射，则将s中的字符映射到pattern中，记录pattern的当前字符已经被映射
					map[c1] = c2;
					vis[c2] = 1;
					// 若当前字符已经被映射到pattern中，则查看当前字符之前的映射与当前映射是否相同
				}else if (map[c1] != c2) {
					ok = false;
				}
    		}
    		if (ok) {
				ans.add(s);
			}
    	}
    	return ans;
    }

}
