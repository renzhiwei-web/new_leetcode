package designClass;

public class ImplementMagicDictionary {
	
	// leetcode 676 medium 2022/7/11
	// ���������뵽ʹ��ö�ٷ���
	String[] words;
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
    }
}
