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
        	// 在start和end中找到第一个不是X的字符索引
            while (i < n && start.charAt(i) == 'X') {
                ++i;
            }
            while (j < n && end.charAt(j) == 'X') {
                ++j;
            }
            // 如果已经遍历完，这说明可以替换成功
            if (i == n && j == n) {
                return true;
            }
            // 如果当前两个字符索引不相同，那么返回false
            // 因为R与L是不能替换位置
            if (i == n || j == n || start.charAt(i) != end.charAt(j)) {
                return false;
            }
            // 由于R是往右移，L是往左移，那么在start中R的索引要小于end中R的索引
            // start中L的索引大于end中L的索引
            if (start.charAt(i) == 'L' && i < j || start.charAt(i) == 'R' && i > j) {
                return false;
            }
            ++i;
            ++j;
        }
    }
}
