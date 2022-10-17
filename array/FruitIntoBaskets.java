package array;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
	// leetcode 904 medium 2022/10/17
	// ʹ�û������������н���
    public int totalFruit1(int[] fruits) {
    	// ��ϣ���ŵ�ǰ�������������е���ժ��ˮ�����࣬������Ӧ�ĸ���
    	Map<Integer, Integer> cnt = new HashMap<>();
        int ans = 0;
        for (int i = 0, j = 0; i < fruits.length; ++i) {
            int x = fruits[i];
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
            while (cnt.size() > 2) {
                int y = fruits[j++];
                cnt.put(y, cnt.get(y) - 1);
                if (cnt.get(y) == 0) {
                    cnt.remove(y);
                }
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
    
    // ���������Ż�����Ϊ��ĿҪ����ˮ��������Ŀ��Ҳ���������Ĵ���
    // ����û�б�Ҫ���ٴ��ڴ�С�����Ե�������ˮ�����಻������ĿҪ��ʱ��ֻ��Ҫά�ֵ�ǰ���ڴ�С���ɣ�û�б�Ҫ���ٴ��ڴ�С
    public int totalFruit(int[] fruits) {
    	Map<Integer, Integer> cnt = new HashMap<>();
    	int j = 0;
    	int n = fruits.length;
    	for (int x : fruits) {
    		cnt.put(x, cnt.getOrDefault(x, 0) + 1);
    		// �������ӵ�ˮ��������Ҫ��ֻ��ά�ִ��ڴ�С���ɣ�����Ҫ��С����
    		if (cnt.size() > 2) {
				int y = fruits[j++];
    			cnt.put(y, cnt.get(y) - 1);
    			if (cnt.get(y) == 0) {
					cnt.remove(y);
				}
			}
    	}
    	return n - j;
    }
}
