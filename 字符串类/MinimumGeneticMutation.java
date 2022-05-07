package stringclass;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class MinimumGeneticMutation {
	// leetcode 433 medium 2022/5/7
	// 首先很容易想到暴力法，但是实现的难点是改变一个基因字符，如何判断其在bank中
	// 一开始有点想当然了，start->end的基因变化过程中，不一定每个状态都在bank中，若其中一个状态不在bank中，则无法完成变化
	// 对于使用暴力法来求解类型字符串变化问题有了很好的启示
    public int minMutation1(String start, String end, String[] bank) {
    	Set<String> cnt = new HashSet<>();
    	Set<String> visited = new HashSet<>();
    	char[] keys = {'A','C','G','T'};
    	for(String w : bank) {
    		cnt.add(w);
    	}
    	if (start.equals(end)) {
			return 0;
		}
    	if (!cnt.contains(end)) {
			return -1;
		}
    	Queue<String> queue = new ArrayDeque<>();
    	queue.offer(start);
    	visited.add(start);
    	int step = 1;
    	while(!queue.isEmpty()) {
    		int sz = queue.size();
    		for(int i = 0;i < sz;i++) {
    			String curr = queue.poll();
    			for(int j = 0;j < 8;j++) {
    				for(int k = 0;k < 4;k++) {
    					if (keys[k] != curr.charAt(j)) {
							StringBuilder sb = new StringBuilder(curr);
							sb.setCharAt(j, keys[k]);
							String next = sb.toString();
							if (!visited.contains(next) && cnt.contains(next)) {
								if (next.equals(end)) {
									return step;
								}
								queue.offer(next);
								visited.add(next);
							}
						}
    				}
    			}
    		}
    		step++;
    	}
    	return -1;
    }
    
    // 对bank进行预处理
    public int minMutation(String start, String end, String[] bank) {
    	int len = start.length();
    	int n = bank.length;
    	List<Integer>[] adj = new List[n];//建立邻接列表
    	// 邻接列表的作用是，找出bank中bank[i]可以通过变化一个基因字符的基因
    	for(int i = 0;i < n;i++) {
    		adj[i] = new ArrayList<>();
    	}
    	int endIndex = -1;
    	for(int i = 0;i < n;i++) {
    		if (end.equals(bank[i])) {
				endIndex = i;
			}
    		for(int j = i + 1;j < n;j++) {
    			int mutations = 0;
    			for(int k = 0;k < len;k++) {
    				if (bank[i].charAt(k) != bank[j].charAt(k)) {
						mutations++;
					}
    				if (mutations > 1) {
						break;
					}
    			}
    			if (mutations == 1) {
					adj[i].add(j);//说明bank[i]可以变化到bank[j]
					adj[j].add(i);
				}
    		}
    	}
    	if (endIndex == -1) {
			return -1;
		}
    	// 找到start变化第一个中间状态
    	Queue<Integer> queue = new ArrayDeque<>();
    	boolean[] visited = new boolean[n];
    	int step = 1;
    	for(int i = 0;i < n;i++) {
    		int mutations = 0;
    		for(int k = 0;k < len;k++) {
    			if (start.charAt(k) != bank[i].charAt(k)) {
					mutations++;
				}
    			if (mutations > 1) {
					break;
				}
    		}
    		if (mutations == 1) {
				queue.offer(i);
				visited[i] = true;
			}
    	}
    	
    	while(!queue.isEmpty()) {
    		int sz = queue.size();
    		for(int i = 0;i < sz;i++) {
    			int curr = queue.poll();
    			if (curr == endIndex) {
					return step;
				}
    			for(int next : adj[curr]) {
    				if (visited[next]) {
						continue;
					}
    				visited[next] = true;
    				queue.offer(next);
    			}
    		}
    		step++;
    	}
    	return -1;
    }
}
