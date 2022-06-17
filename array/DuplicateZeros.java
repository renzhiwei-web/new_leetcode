package array;

import java.util.Stack;

public class DuplicateZeros {
	// leetcode 1089 simple 2022/6/17
	// �����뵽ʹ�ö���ռ���������⣬���ǲ�������Ŀԭ�ظı������Ҫ��
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
	
	// ���Ҫ��ԭ�ظı����飬�����ҵ��������м���0����ʵʱ��ƽ�������е�����Ԫ��
	// ��������Ļ����Ḳ�������е�����Ԫ�أ���Щ�����ǵ�Ԫ�أ����޷���ƽ��
	// ����ʹ��������������ÿ��Ǳ����ǵ�Ԫ��
    public void duplicateZeros(int[] arr) {
    	int n = arr.length;
    	int top = 0;// top��ʾջ����λ��
    	int i = -1;// ��ʾ������Ҫ���õ�Ԫ��λ��
    	while(top < n) {//�����ҵ�ջ��λ��
    		i++;
    		if (arr[i] != 0) {
				top++;
			}else {
				top += 2;
			}
    	}
    	int j = n - 1;
    	if (top == n + 1) {//������������ϣ���˵������topλ�ã�������������0
			arr[j] = 0;
			j--;
			i--;
		}
    	// �Ӻ���ǰ�ƶ����������Բ��ÿ��Ǳ����ǵ�Ԫ��
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
