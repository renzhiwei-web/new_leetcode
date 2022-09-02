package tree;

public class LongestUnivaluePath {
	// leetcode 687 medium 2022/9/2
	// ������ɵã��ڶ���������·��������ͨ�������ڵ������������·������ӿɵ�
	// ���������νṹ��ʹ�õݹ��˼��
	private int maxL = 0;
	
    public int longestUnivaluePath(TreeNode root) {
    	if (root == null) {
			return 0;
		}
    	getMaxL(root,root.val);
    	return maxL;
    }

	private int getMaxL(TreeNode root, int val) {
		if (root == null) {
			return 0;
		}
		int left = getMaxL(root.left, root.val);
		int right = getMaxL(root.right, root.val);
		maxL = Math.max(maxL, left + right);
		if (root.val == val) {
			return Math.max(left, right) + 1;// ·�����ֲܷ棬����ѡȡ���·��
		}
		return 0;
	}
}
