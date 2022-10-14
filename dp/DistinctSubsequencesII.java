package dp;

public class DistinctSubsequencesII {
	// leetcode 940 hard 2022/10/14
	// �ַ����Ӵ�����������ʹ�ö�̬�滮
	public int distinctSubseqII(String s) {
	 int mod = (int) 1e9 + 7;
     int n = s.length();
     //֮ǰ�����ĸ���
     int[] preCount = new int[26];
     // �մ�
     int curAns = 1;
     char[] chs = s.toCharArray();
     for (int i = 0; i < n; i++) {
         //�����ĸ���
         int newCount = curAns;
         //��ǰ���еĸ��� = ֮ǰ�� + ������ - �ظ���
         // ��modΪ�˷�ֹ���ָ���
         curAns = ((curAns + newCount) % mod - preCount[chs[i] - 'a'] % mod + mod) % mod;
         //��¼��ǰ�ַ��� ����ֵ
         preCount[chs[i] - 'a'] = newCount;
     }
     //��ȥ�մ�
     return curAns - 1;
	}
}
