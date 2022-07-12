package designClass;

public class ImplementMagicDictionary {
	
	// leetcode 676 medium 2022/7/11
	// 首先容易想到使用枚举方法
	/*String[] words;
    public ImplementMagicDictionary() { 

    }
    
    public void buildDict(String[] dictionary) {
    	words = dictionary;
    }
    
    public boolean search(String searchWord) {
    	for(String word : words) {
    		if (word.length() != searchWord.length()) {
				continue;
			}
    		int diff = 0;
    		for(int i = 0;i < word.length();i++) {
    			if(word.charAt(i) != searchWord.charAt(i)) {
    				diff++;
    			}
    			if (diff > 1) {
					break;
				}
    		}
    		if (diff == 1) {
				return true;
			}
    	}
    	return false;
    }*/
	Trie root;
	
	public ImplementMagicDictionary() { 
		root = new Trie();
    }
	
	public void buildDict(String[] dictionary) {
		for(String word : dictionary) {
			Trie cur = root;
			for(int i = 0;i < word.length();i++) {
				char ch = word.charAt(i);
				int idx = ch - 'a';
				if (cur.child[idx] == null) {
					cur.child[idx] = new Trie();
				}
				cur = cur.child[idx];
			}
			cur.isFinished = true;
		}
	}
	
	public boolean search(String searchWord) {
		return dfs(searchWord,root,0,false);
	}
	
	
	private boolean dfs(String searchWord, Trie node, int pos, boolean modified) {
		if (pos == searchWord.length()) {
			return modified & node.isFinished;
		}
		int idx = searchWord.charAt(pos) - 'a';
		if (node.child[idx] != null) {
			if (dfs(searchWord, node.child[idx], pos + 1, modified)) {
				return true;
			}
		}
		if (!modified) {
			for(int i = 0;i < 26;i++) {
				if (i != idx && node.child[i] != null) {
					if (dfs(searchWord, node.child[i], pos + 1, true)) {
						return true;
					}
				}
			}
		}
		return false;
	}


	class Trie {
	    boolean isFinished;
	    Trie[] child;

	    public Trie() {
	        isFinished = false;
	        child = new Trie[26];
	    }
	}
}
