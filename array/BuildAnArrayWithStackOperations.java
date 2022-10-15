package array;

import java.util.ArrayList;
import java.util.List;

public class BuildAnArrayWithStackOperations {
	// leetcode 1441 medium 2022/10/15
	// 入栈顺序问题
	String push = "Push";
	String Pop = "Pop";
    public List<String> buildArray(int[] target, int n) {
    	// 记录应该进栈的元素
    	int i = 1;
    	List<String> ans = new ArrayList<>();
    	// 遍历target数组
    	for(int num : target) {
    		//如果当前遍历的元素不是当前顺序应该进栈的元素
    		if (num != i) {
    			// 将[i , num)之间的元素全部进栈然后再出栈
				while(i < num) {
					ans.add(push);
					ans.add(Pop);
					i++;
				}
    		}
    		// 最后进栈num元素，更新i
    		ans.add(push);
    		i++;
				
    	}
    	return ans;
    }
}
