package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
	
	// 朴素的哈希表法
    public List<Integer> findSubstring1(String s, String[] words) {
    	int len = s.length();
    	int n = words.length;
    	int m = words[0].length();
    	List<Integer> ans = new ArrayList<>();
    	if (len < m * n) {
			return ans;
		}
    	
    	Map<String, Integer> map = new HashMap<>();
    	for(String word : words) {
    		map.put(word, map.getOrDefault(word, 0) + 1);
    	}
    	out:for(int i = 0;i + m * n <= len;i++) {
    		Map<String, Integer> cur = new HashMap<>();
    		String sub = s.substring(i, i + m * n);
    		for(int j = 0;j < sub.length();j += m) {
    			String item = sub.substring(j, j + m);
    			if (!map.containsKey(item)) {
					continue out;
				}
    			cur.put(item, cur.getOrDefault(item, 0) + 1);
    		}
    		if (cur.equals(map)) {
				ans.add(i);
			}
    	}
    	return ans;
    }
    
    // 滑动窗口
    public List<Integer> findSubstring(String s, String[] words) {
    	int len = s.length();
    	int n = words.length;
    	int m = words[0].length();
    	List<Integer> ans = new ArrayList<>();
    	if (len < m * n) {
			return ans;
		}
    	
    	Map<String, Integer> map = new HashMap<>();
    	for(String word : words) {
    		map.put(word, map.getOrDefault(word, 0) + 1);
    	}
    	
    	for(int i = 0;i < m;i++) {
    		// 构建一个当前子串对应的哈希表，统计当前子串中每个目标单词的出现次数
    		Map<String, Integer> temp = new HashMap<>();
    		// 滑动窗口的大小是固定的m * n，每次将下一个单词添加进temp，上一个单词移除temp
    		for(int j = i;j + m <= len;j += m) {
    			String cur = s.substring(j,j + m);
    			temp.put(cur, temp.getOrDefault(cur, 0) + 1);
    			if (j >= i + (m * n)) {
					int idx = j - m * n;
					String prev = s.substring(idx, idx + m);
					if (temp.get(prev) == 1) {
						temp.remove(prev);
					}else {
						temp.put(prev, temp.get(prev) - 1);
					}
					if (!temp.getOrDefault(prev, 0).equals(map.getOrDefault(prev, 0))) {
						continue;
					}
				}
    			if (!temp.getOrDefault(cur, 0).equals(map.getOrDefault(cur, 0))) {
					continue;
				}
    			if (temp.equals(map)) {
					ans.add(j - (n - 1) * m);
				}
    		}
    	}
    	return ans;
    }
}
