package stringclass;

public class UniqueSubstringsInWraparoundString {
	// leetcode 467 medium 2022/5/25
	//只需判断以每个字母结尾的最长字符串长度，最后累加即可
	//降低复杂度使用双指针分别代表当前连续串的开头和结尾
	//注意每个结尾都要更新对应位置的唯一串长度
    public int findSubstringInWraproundString(String p) {
    	int[] leeters = new int[26];
    	char[] ps = p.toCharArray();
    	for(int i = 0;i < ps.length;) {
    		int j = i;
    		leeters[ps[i] - 'a'] = Math.max(leeters[ps[i] - 'a'], 1);
    		//                          相邻的字符在字母表中相邻       或者循环相邻
    		while(j + 1 < ps.length && (ps[j + 1] - ps[j] == 1 || ps[j] == 'z' && ps[j + 1] == 'a')) {
    			j++;
    			int index = ps[j] - 'a';
    			leeters[index] = Math.max(leeters[index], j - i + 1);
    		}
    		i = j + 1;
    	}
    	int sum = 0;
    	for(int v : leeters) {
    		sum += v;
    	}
    	return sum;
    	
    }
}
