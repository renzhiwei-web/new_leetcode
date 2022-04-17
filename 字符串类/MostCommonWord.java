package stringclass;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {
	// leetcode 819 simple,2022/4/17
	// 简单的进行模拟即可，主要的难点是paragraph中有的单词的首字母大写，需要转换成小写字母
	public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        for (String word : banned) {
        	bannedSet.add(word);
        }
        // 处理paragraph
        char[] cs = paragraph.toCharArray();
        String ans = "";
        Map<String, Integer> frequencies = new HashMap<>();
        int length = paragraph.length();
        for(int i = 0;i < length;) {
        	if (!Character.isLetter(cs[i]) && ++i >= 0) {
				continue;
			}// 表示一个单词处理完毕
        	int j = i;
        	while (j < length && Character.isLetter(cs[j])) {
				j++;
			}
        	String word = paragraph.substring(i,j).toLowerCase();
        	i = j + 1;
        	if(bannedSet.contains(word)) {
        		continue;
        	}
        	frequencies.put(word, frequencies.getOrDefault(word, 0) + 1);
        	if(ans == "" || frequencies.get(ans) < frequencies.get(word)) {
        		ans = word;
        	}
        }
       return ans;
    }
}
