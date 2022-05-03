package stringclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReorderDataInLogFiles {
	// leetcode 937 simple 2022/5/3
	// 学习使用compare方法
	class Log{
		int type,idx;
		String ori,sign,content;
		public Log(String s,int _idx) {
			idx = _idx;
			int n = s.length(),i = 0;
			while(i < n && s.charAt(i) != ' ') {
				i++;
			}
			sign = s.substring(0,i);//标识符
			content = s.substring(i + 1);//日志内容
			ori = s;
			type = Character.isDigit(content.charAt(0)) ? 1 : 0;//如果日志内容是数字，则是数字日志
		}
	}
	
	public String[] reorderLogFiles(String[] logs) {
		int n = logs.length;
		List<Log> list = new ArrayList<>();
		for(int i = 0;i < n;i++) {
			list.add(new Log(logs[i], i));
		}
		Collections.sort(list,(a,b) -> {
			if (a.type != b.type) {//如果日志类型不相同，则字母日志放在数字日志之前
				return a.type - b.type;//如果是正数，则升序，如果是负数，则降序
			}
			if (a.type == 1) {//如果是数字日志，则按照原始顺序排列
				return a.idx - b.idx;
			}
			return !a.content.equals(b.content) ? a.content.compareTo(b.content) : a.sign.compareTo(b.sign);//如果是字母类型日志，先按照内容进行字母排序，后按照标识符进行字母排序
		});
		String[] ans = new String[n];
		for(int i = 0;i < n;i++) {
			ans[i] = list.get(i).ori;
		}
		return ans;
	}
}
package stringclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReorderDataInLogFiles {
	// leetcode 937 simple 2022/5/3
	// 学习使用compare方法
	class Log{
		int type,idx;
		String ori,sign,content;
		public Log(String s,int _idx) {
			idx = _idx;
			int n = s.length(),i = 0;
			while(i < n && s.charAt(i) != ' ') {
				i++;
			}
			sign = s.substring(0,i);//标识符
			content = s.substring(i + 1);//日志内容
			ori = s;
			type = Character.isDigit(content.charAt(0)) ? 1 : 0;//如果日志内容是数字，则是数字日志
		}
	}
	
	public String[] reorderLogFiles(String[] logs) {
		int n = logs.length;
		List<Log> list = new ArrayList<>();
		for(int i = 0;i < n;i++) {
			list.add(new Log(logs[i], i));
		}
		Collections.sort(list,(a,b) -> {
			if (a.type != b.type) {//如果日志类型不相同，则字母日志放在数字日志之前
				return a.type - b.type;//如果是正数，则升序，如果是负数，则降序
			}
			if (a.type == 1) {//如果是数字日志，则按照原始顺序排列
				return a.idx - b.idx;
			}
			return !a.content.equals(b.content) ? a.content.compareTo(b.content) : a.sign.compareTo(b.sign);//如果是字母类型日志，先按照内容进行字母排序，后按照标识符进行字母排序
		});
		String[] ans = new String[n];
		for(int i = 0;i < n;i++) {
			ans[i] = list.get(i).ori;
		}
		return ans;
	}
}
