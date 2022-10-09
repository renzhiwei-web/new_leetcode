package divideandconquer;

public class ScoreOfParentheses {
	// leetcode 856 medium 2022/10/9
	// �������⣬�����뵽���λ���ջ
	// �����㷨
    public int scoreOfParentheses(String s) {
    	if (s.length() == 2) {
			return 1;
		}
    	// bal��¼��ǰ�����Ƿ��Ǳպϵ�
    	int bal = 0, n = s.length(),len = 0;
    	for(int i = 0;i < n;i++) {
    		bal += (s.charAt(i) == '(' ? 1 : -1);
    		if (bal == 0) {// �����ǰ�������Ǳպϵģ������ѭ�����ֽ�����
				len = i + 1;
				break;
			}
    	}
    	// (A) �ķ�����2 * A
    	if (len == n) {
			return 2 * scoreOfParentheses(s.substring(1, n - 1));
		}else {
			// () + ()
			return scoreOfParentheses(s.substring(0, len)) + scoreOfParentheses(s.substring(len));
		}
    }
    
    // ջ + �����㷨��������ɵã�ֻ��()�Ų�����������()�����ķ���ȡ����()����ȣ���һ��()���Ϊ0
    public int scoreOfParentheses1(String s) {
    	if (s.length() == 2) {
			return 1;
		}
    	int n = s.length();
    	int d = 0;//���
    	int ans = 0;
    	for(int i = 0;i < n;i++) {
    		if (s.charAt(i) == '(') {
				d++;
			}else {
				d--;
				if (s.charAt(i - 1) == '(') {
					ans += 1 << d;
				}
			}
    	}
    	return ans;
    }
}
