package array;

import java.util.ArrayList;
import java.util.List;

public class BuildAnArrayWithStackOperations {
	// leetcode 1441 medium 2022/10/15
	// ��ջ˳������
	String push = "Push";
	String Pop = "Pop";
    public List<String> buildArray(int[] target, int n) {
    	// ��¼Ӧ�ý�ջ��Ԫ��
    	int i = 1;
    	List<String> ans = new ArrayList<>();
    	// ����target����
    	for(int num : target) {
    		//�����ǰ������Ԫ�ز��ǵ�ǰ˳��Ӧ�ý�ջ��Ԫ��
    		if (num != i) {
    			// ��[i , num)֮���Ԫ��ȫ����ջȻ���ٳ�ջ
				while(i < num) {
					ans.add(push);
					ans.add(Pop);
					i++;
				}
    		}
    		// ����ջnumԪ�أ�����i
    		ans.add(push);
    		i++;
				
    	}
    	return ans;
    }
}
