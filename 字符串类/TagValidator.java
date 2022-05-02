package stringclass;

import java.util.ArrayDeque;
import java.util.Deque;

public class TagValidator {
	// leetcode 591 hard 2022/5/2
	// 首先容易想到使用栈来保存并配对标签，但难点在于状态太多，容易漏掉状态
    public boolean isValid(String code) {
    	int n = code.length();
    	Deque<String> tags = new ArrayDeque<>();
    	int i = 0;
    	while(i < n) {
    		if (code.charAt(i) == '<') {
				if (i == n - 1) {
					return false;
				}
				if (code.charAt(i + 1) == '/') {//如果是结束标签
					int j = code.indexOf('>', i);//学习的新方法，从索引i开始判断有无>
					if (j < 0) {
						return false;
					}
					String tagname = code.substring(i+ 2,j);
					if (tags.isEmpty() || !tags.peek().equals(tagname)) {
						return false;
					}
					tags.pop();
					i = j + 1;
					if (tags.isEmpty() && i != n) {
						return false;
					}
				}else if (code.charAt(i + 1) == '!') {//如果是数据标签
					if (tags.isEmpty()) {
						return false;
					}
					if (i + 9 > n) {
						return false;
					}
					String cdata = code.substring(i + 2,i + 9);
					if (!"[CDATA[".equals(cdata)) {
						return false;
					}
					int j = code.indexOf("]]>",i);
					if (j < 0) {
						return false;
					}
					i = j + 1;
				}else {//如果是开始标签
					int j = code.indexOf('>',i);
					if (j < 0) {
						return false;
					}
					String tagname = code.substring(i + 1,j);
					if (tagname.length() < 1 || tagname.length() > 9) {
						return false;
					}
					for(int k = 0;k < tagname.length();k++) {
						if (!Character.isUpperCase(tagname.charAt(k))) {
							return false;
						}
					}
					tags.push(tagname);
					i = j + 1;
				}
			}else {//如果是标签中的内容
				if (tags.isEmpty()) {//有内容，则必须有标签
					return false;
				}
				i++;
			}
    	}
    	return tags.isEmpty();
    }
}
