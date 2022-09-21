package stringclass;

public class KSimilarStrings {
	// leetcode 854 hard 2022/9/21
	// ʹ�û��ݷ����б�����ע����ݷ��Ľ�������
	int result = Integer.MAX_VALUE;
    public int kSimilarity(String s1, String s2) {
    	return execute(s1.toCharArray(),s2.toCharArray(),0,0);
    }
	private int execute(char[] sc1, char[] sc2, int start, int current) {
		if (current >= result) {
			return result; // ������������Ѿ�������Ŀǰ��С��������������ֹ�ݹ�
		}
		if (start == sc1.length - 1) { // ����Ѿ��������
			return result = Math.min(current, result);
		}
		
		for(int i = start;i < sc1.length;i++) {
			if (sc1[i] != sc2[i]) {//��ǰ�����ַ���ƥ�䣬�����Ѱ��ƥ����ַ�
				for(int j = i + 1;j < sc2.length;j++) {
					if (sc2[j] == sc1[i] && sc2[j] != sc1[j]) {
						swap(sc2,i,j);//����
						execute(sc1, sc2, i + 1, current + 1);
						swap(sc2,i,j);// ����
						if (sc2[i] == sc1[j]) {// ���sc1��sc2��iλ��jλ��Ϊ��ȣ���ô�������Ž���
							break;
						}
					}
					
				}
				return result;
			}
			
		}
		return result = Math.min(current, result);
	}
	private void swap(char[] sc, int i, int j) {
		char temp = sc[i];
		sc[i] = sc[j];
		sc[j] = temp;
		
	}
}
