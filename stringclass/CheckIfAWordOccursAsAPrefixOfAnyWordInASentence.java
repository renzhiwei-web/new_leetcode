package stringclass;

public class CheckIfAWordOccursAsAPrefixOfAnyWordInASentence {
	// leetcode 1455 simple 2022/8/21
	// ¼òµ¥Ä£Äâ¼´¿É
    public int isPrefixOfWord(String sentence, String searchWord) {
    	int ans = -1;
    	String[] ss = sentence.split(" ");
    	for(int i = 0;i < ss.length;i++) {
    		if (ss[i].indexOf(searchWord) == 0) {
				ans = i + 1;
				break;
			}
    	}
    	return ans;
    }
}
