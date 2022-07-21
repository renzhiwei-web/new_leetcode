package tree;

public class BinaryTreePruning {
	// leetcode 814 medium 2022/7/21
	// ���������Ƕ�������Ŀ���뵽ʹ�õݹ�������
	// ��ؼ��Ĳ����ǣ���ǰ�ڵ���û���ӽڵ㣬��ֵΪ0ʱ������null
    public TreeNode pruneTree(TreeNode root) {
    	if (root == null) {
			return null;
		}
    	root.left = pruneTree(root.left);
    	root.right = pruneTree(root.right);
    	if (root.left == null && root.right == null && root.val == 0) {
			return null;
		}
    	return root;
    }
}
