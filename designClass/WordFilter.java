package designClass;

import java.util.HashMap;
import java.util.Map;

public class WordFilter {
	// leetcode 745 hard 2022/7/14
	// 首先使用暴力破解问题
	/*Map<String, Integer> dict;
    public WordFilter(String[] words) {
    	dict = new HashMap<>();
    	for(int i = 0;i < words.length;i++) {
    		String word = words[i];
    		int len = word.length();
    		for(int prefix = 1;prefix <= len;prefix++) {
    			for(int suffix = 1;suffix <= len;suffix++) {
    				dict.put(word.subSequence(0, prefix) + "#" + word.substring(len - suffix), i);
    			}
    		}
    	}
    }
    
    public int f(String pref, String suff) {
    	return dict.getOrDefault(pref + "#" + suff,-1);
    }*/
	
	// 观察题目，比较容易想到使用字典树来进行解题，通过将每个单词的正序与反序插入字典树
	
	Trie trie;
	String weightKey;
	
	public WordFilter(String[] words) {
		trie = new Trie();
		weightKey = "##";
		for(int i = 0;i < words.length;i++) {
			String word = words[i];
			Trie cur = trie;
			int m = word.length();
			for(int j = 0;j < m;j++) {
				Trie temp = cur;
				for(int k = j;k < m;k++) {
					String key = new StringBuilder().append(word.charAt(k)).append('#').toString();
					if (!temp.children.containsKey(key)) {
						temp.children.put(key, new Trie());
					}
					temp = temp.children.get(key);
					temp.weight.put(weightKey, i);
				}
				temp = cur;
				for(int k = j;k < m;k++) {
					String key = new StringBuilder().append("#").append(word.charAt(m - k - 1)).toString();
					if (!temp.children.containsKey(key)) {
						temp.children.put(key, new Trie());
					}
					temp = temp.children.get(key);
					temp.weight.put(weightKey, i);
				}
				String key = new StringBuilder().append(word.charAt(j)).append(word.charAt(m - j - 1)).toString();
				if (!cur.children.containsKey(key)) {
					cur.children.put(key, new Trie());
				}
				cur = cur.children.get(key);
				cur.weight.put(weightKey, i);
			}
		}
    }
    
    public int f(String pref, String suff) {
    	Trie cur = trie;
    	int m = Math.max(pref.length(), suff.length());
    	for(int i = 0;i < m;i++) {
    		char c1 = i < pref.length() ? pref.charAt(i) : '#';
    		char c2 = i < suff.length() ? suff.charAt(suff.length() - 1 - i) : '#';
    		String key = new StringBuilder().append(c1).append(c2).toString();
    		if (!cur.children.containsKey(key)) {
				return -1;
			}
    		cur = cur.children.get(key);
    	}
    	return cur.weight.get(weightKey);
    }
    
    class Trie {
        Map<String, Trie> children;
        Map<String, Integer> weight;

        public Trie() {
            children = new HashMap<String, Trie>();
            weight = new HashMap<String, Integer>();
        }
    }
}
