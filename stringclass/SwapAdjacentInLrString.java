package stringclass;

public class SwapAdjacentInLrString {
//    public boolean canTransform(String start, String end) {
//        if (lastXfontR(start) == lastXfontR(end) && firstXlaterL(start) == firstXlaterL(end)) {
//			return true;
//		}
//        return false;
//        
//    }
//    
//    private int lastXfontR(String s) {
//    	char[] startcs = s.toCharArray();
//        int lastX = -1;
//        int lastXfrontR = 0;
//        for(int i = startcs.length - 1;i >= 0;i--) {
//        	if (lastX == -1 && startcs[i] == 'X') {
//				lastX = i;
//			}
//        	if (lastX != -1 && startcs[i] == 'R') {
//				lastXfrontR++;
//			}
//        }
//        return lastXfrontR;
//	}
//    
//    private int firstXlaterL(String s) {
//    	char[] startcs = s.toCharArray();
//    	int firstX = -1;
//        int firstXlaterL = 0;
//        for(int i = 0;i < startcs.length;i++) {
//        	if (firstX == -1 && startcs[i] == 'X') {
//				firstX = i;
//			}
//        	if (firstX != -1 && startcs[i] == 'L') {
//				firstXlaterL++;
//			}
//        }
//        return firstXlaterL;
//    }
	// leetcode 777 medium 2022/10/2
	public boolean canTransform(String start, String end) {
        int n = start.length();
        int i = 0, j = 0;
        while (true) {
        	// ��start��end���ҵ���һ������X���ַ�����
            while (i < n && start.charAt(i) == 'X') {
                ++i;
            }
            while (j < n && end.charAt(j) == 'X') {
                ++j;
            }
            // ����Ѿ������꣬��˵�������滻�ɹ�
            if (i == n && j == n) {
                return true;
            }
            // �����ǰ�����ַ���������ͬ����ô����false
            // ��ΪR��L�ǲ����滻λ��
            if (i == n || j == n || start.charAt(i) != end.charAt(j)) {
                return false;
            }
            // ����R�������ƣ�L�������ƣ���ô��start��R������ҪС��end��R������
            // start��L����������end��L������
            if (start.charAt(i) == 'L' && i < j || start.charAt(i) == 'R' && i > j) {
                return false;
            }
            ++i;
            ++j;
        }
    }
}
