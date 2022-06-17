package array;

import java.util.Stack;

public class DuplicateZeros {
	// leetcode 1089 simple 2022/6/17
	// 容易想到使用额外空间来解决问题，但是不符合题目原地改变数组的要求
	public void duplicateZeros1(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		while(stack.size() < arr.length) {
			if (arr[i] == 0) {
				stack.push(arr[i]);
			}
			stack.push(arr[i]);
			i++;
		}
		if (stack.size() > arr.length) {
			stack.pop();
		}
		for(int j = arr.length - 1;j >= 0;j--) {
			arr[j] = stack.pop();
		}
	}
	
	// 如果要想原地改变数组，必须找到数组中有几个0，再实时的平移数组中的其他元素
	// 正序遍历的话，会覆盖数组中的其他元素，这些被覆盖的元素，将无法被平移
	// 所以使用逆序遍历，不用考虑被覆盖的元素
    public void duplicateZeros(int[] arr) {
    	int n = arr.length;
    	int top = 0;// top表示栈顶的位置
    	int i = -1;// 表示现在需要放置的元素位置
    	while(top < n) {//首先找到栈顶位置
    		i++;
    		if (arr[i] != 0) {
				top++;
			}else {
				top += 2;
			}
    	}
    	int j = n - 1;
    	if (top == n + 1) {//如果该条件符合，则说明最后的top位置，连续放置两个0
			arr[j] = 0;
			j--;
			i--;
		}
    	// 从后往前移动，这样可以不用考虑被覆盖的元素
    	while(j >= 0) {
    		arr[j] = arr[i];
    		j--;
    		if (arr[i] == 0) {
				arr[j] = arr[i];
				j--;
			}
    		i--;
    	}
    }
    
}
