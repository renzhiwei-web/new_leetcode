package stringclass;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReplaceWords {
	// leetcode 648 medium 2022/7/7
	// 首先想到逐个单词的进行处理，使用哈希表
    public String replaceWords1(List<String> dictionary, String sentence) {
    	Set<String> dictionarySet = new HashSet<>();
    	for(String root : dictionary) {
    		dictionarySet.add(root);
    	}
    	String[] words = sentence.split(" ");
    	for(int i = 0;i < words.length;i++) {
    		String word = words[i];
    		for(int j = 0;j < word.length();j++) {
    			if (dictionarySet.contains(word.substring(0, j + 1))) {
					words[i] = word.substring(0, j + 1);
					break;
				}
    		}
    	}
    	return String.join(" ", words);
    }
    
    // 字典树
    public String replaceWords(List<String> dictionary, String sentence) {
    	Trie trie = new Trie();
    	for(String word : dictionary) {
    		Trie cur = trie;
    		for(int i = 0;i < word.length();i++) {
    			char c = word.charAt(i);
    			cur.children.putIfAbsent(c, new Trie());
    			cur = cur.children.get(c);
    		}
    		cur.children.put('#', new Trie());// #号是特殊标记，用来标识结尾
    	}
    	String[] words = sentence.split(" ");
    	for(int i = 0;i < words.length;i++) {
    		words[i] = findRoot(words[i],trie);
    	}
    	return String.join(" ", words);
    }
    
    private String findRoot(String word, Trie trie) {
		StringBuffer root = new StringBuffer();
		Trie cur = trie;
		for(int i = 0;i < word.length();i++) {
			char c = word.charAt(i);
			if (cur.children.containsKey('#')) {
				return root.toString();
			}
			if (!cur.children.containsKey(c)) {
				return word;
			}
			root.append(c);
			cur = cur.children.get(c);
		}
		return root.toString();
	}

	class Trie {
        Map<Character, Trie> children;

        public Trie() {
            children = new HashMap<Character, Trie>();
        }
    }

}
