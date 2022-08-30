package tree;

public class MaximumBinaryTreeII {
	//leetcode 998 medium 2022/8/30
	// ��leecode 654 �����չ�⣬˼·��ͬ
	// ���������б��ĩβ����Ԫ�أ�����ֻ��Ҫ�����ĸ��ڵ�һֱ���ұ�������
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
    	
    	// ����ǰ�������Ľڵ�Ϊ�գ��� ����ڵ� ����
    	if (root == null) {
			return new TreeNode(val);
		}
    	// ����ǰ�ڵ��ֵС�� �������ֵ���򽫲���ڵ���뵽��ǰλ�ã�
    	// ��ǰ�ڵ��ɲ���ڵ������������Ϊԭ�������ڵ��ڲ���ڵ�����
    	if (root.val < val) {
    		TreeNode insertNode = new TreeNode(val);
			insertNode.left = root;
			return insertNode;
		}
    	// ����ǰ�ڵ��ֵ���� �������ֵ�������������������
    	root.right = insertIntoMaxTree(root.right, val);
    	return root;
    }
}
