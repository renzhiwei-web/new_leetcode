package stringclass;

public class GoatLatin {
    public String toGoatLatin(String sentence) {
    	// leetcode 824 simple 2022/4/21
    	// 简单模拟即可
    	String[] words = sentence.split(" ");
    	StringBuilder ans = new StringBuilder();
    	for(int i = 0;i < words.length;i++) {
    		StringBuilder sb = new StringBuilder();
    		if(isVowels(words[i].charAt(0))) {// 如果首字母是元音字符
    			sb.append(words[i]);
    		}else {
    			sb.append(words[i].substring(1));
    			sb.append(words[i].substring(0, 1));
    		}
    		sb.append("ma");
    		for(int j = 0;j <= i;j++) {
				sb.append("a");
			}
    		if(i >= 1) {
    			ans.append(" ");
    		}
    		ans.append(sb);
    	}
    	return ans.toString();
    }
    
    private boolean isVowels(char c) {
		return "aeiouAEIOU".indexOf(c) >= 0;
	}
}
