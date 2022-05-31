package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {
	// leetcode 2542 hard 2022/5/31
	// 学习使用拓扑排序解题
    public String alienOrder(String[] words) {
    	int n = words.length;
    	int[] inDegree = new int[26];// 入度表
    	List<List<Integer>> adjTable = new ArrayList<>(); // 邻接表
    	for(int i = 0;i < 26;i++) {
    		inDegree[i] = -1; // 初始化入度表
    		adjTable.add(new ArrayList<>()); // 初始化邻接表
    	}
    	
    	for(String word : words) {
    		for(int i = 0;i < word.length();i++) {
    			inDegree[word.charAt(i) - 'a'] = 0;// 出现的字母将入度更改为0
    		}
    	}
    	
    	// 我们只需要相邻的像个字符串建立邻接关系
    	// 构建有向无环图
    	for(int i = 0;i < n - 1;i++) {
    		String s = words[i];
    		String t = words[i + 1];
    		int m = Math.min(s.length(), t.length());
    		for(int j = 0;j < m;j++) {
    			int from = s.charAt(j) - 'a';
    			int to = t.charAt(j) - 'a';
    			// 出现不同，直接构建邻接关系和入度关系
    			// 将前面一个字符串第一个不同的字符作为from
    			// 将后面一个字符串第一个不同的字符作为to
    			// 构建邻接关系
    			if (from != to) {
					adjTable.get(from).add(to);
					// 由于有字符的字典顺序优先于to，则说明to字符有入度，增加to字符的入度
					inDegree[to]++;
					break;
				// 和第二种情况违背，返回""
				}else if (j == m - 1 && s.length() > t.length()) {
					return "";
				}
    		}
    	}
    	
    	
    	//经典的拓扑排序
    	StringBuilder sb = new StringBuilder();
    	Queue<Integer> queue = new ArrayDeque<>();
    	int cnt = 0;
    	
    	for(int i = 0;i < 26;i++) {
    		//找到没有入度的字符
    		if (inDegree[i] == 0) {
				queue.add(i);
			}
    		// 统计出现了多少不同的字母
    		if (inDegree[i] != -1) {
				cnt++;
			}
    	}
    	while(!queue.isEmpty()) {
    		int temp = queue.poll();
    		sb.append((char)(temp + 'a'));
    		// 遍历由temp字符的出度关系，并除去关系
    		for(int cour : adjTable.get(temp)) {
    			inDegree[cour]--;
    			if (inDegree[cour] == 0) {
					queue.add(cour);
				}
    		}
    	}
    	if (cnt != sb.length()) {
			return "";
		}
    	return sb.toString();
    }
}
