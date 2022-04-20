package tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestAbsoluteFilePath {
	// leetcode 388 medium 2022/4/20
	// 仔细审题，发现：对于每隔文件或者文件夹而言，我们可以通过访问结尾\n的方式获得
	// 文件或者文件夹前的\t的数目来获知其所在的层级
	// 注意：路径标识符也算路径长度
	// 首先想到的做法时逐个遍历，难点是若是有多个文件，如何将文件分离出来
	public int lengthLongestPath1(String input) {
		char[] filePath = input.toCharArray();
		int n = filePath.length;
		int[] level = new int[n + 1];//记录每层深度的最长路径，由于不知道具体有多少层，所以使用最大化数组方式
 		int ans = 0;//结果
		int pos = 0;//表示当前遍历的位置
		while(pos < n) {
			int depth = 1;//表示当前遍历的深度，从1开始
			while(pos < n && filePath[pos] == '\t') {//计算当前文件夹或文件的深度
				pos++;
				depth++;
			}
			// 计算当前文件夹名或文件名的长度
			int len = 0;
			boolean isFile = false;//判断当前遍历的是否是文件
			while(pos < n && filePath[pos] != '\n') {
				if(filePath[pos] == '.') {//通过是否有文件后缀名来表示是否是文件
					isFile = true;
				}
				pos++;
				len++;
			}
			//跳过\n
			pos++;
			if(depth > 1) {
				len += level[depth - 1] + 1;//当前文件夹或文件名的绝对路径长度，+1是文件路径符号
			}
			if (isFile) {
				ans = Math.max(ans, len);
			}else {
				level[depth] = len;
			}
		}
		return ans;
    }
	
	// 由于是文件系统，很容易想到这是树形结构，可以使用深度优先搜索遍历
	// 难点是所给的数据结构不是树形结构，不容易进行dfs
	public int lengthLongestPath(String input) {
		char[] filePath = input.toCharArray();
		int n = filePath.length;
		Deque<Integer> stack = new ArrayDeque<Integer>();//与level数组的功能相同
		int ans = 0;
		int pos = 0;
		while(pos < n) {
			int depth = 1;//表示当前遍历的深度，从1开始
			while(pos < n && filePath[pos] == '\t') {//计算当前文件夹或文件的深度
				pos++;
				depth++;
			}
			// 计算当前文件夹名或文件名的长度
			int len = 0;
			boolean isFile = false;//判断当前遍历的是否是文件
			while(pos < n && filePath[pos] != '\n') {
				if(filePath[pos] == '.') {//通过是否有文件后缀名来表示是否是文件
					isFile = true;
				}
				pos++;
				len++;
			}
			//跳过\n
			pos++;
			//表明出现路径转化
			while(stack.size() >= depth) {
				stack.pop();
			}
			if (!stack.isEmpty()) {
				len += stack.peek() + 1;
			}
			if (isFile) {
				ans = Math.max(ans, len);
			}else {
				stack.push(len);
			}
		}
		return ans;
	}
}
