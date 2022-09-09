package array;

public class CrawlerLogFolder {
    public int minOperations(String[] logs) {
    	// leetcode 1598 simple 2022/9/9
    	// ¼òµ¥Ä£Äâ¼´¿É
    	int depth = 0;
    	for(int i = 0;i < logs.length;i++) {
    		if (logs[i].equals("../")) {
				depth = Math.max(0, depth - 1);
			}else if (!logs[i].equals("./")) {
				depth++;
			}
    	}
    	return depth;
    }
}
