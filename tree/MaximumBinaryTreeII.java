package tree;

public class MaximumBinaryTreeII {
	//leetcode 998 medium 2022/8/30
	// 与leecode 654 题的扩展题，思路相同
	// 由于是在列表的末尾插入元素，所以只需要从树的根节点一直向右遍历即可
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
    	
    	// 若当前所遍历的节点为空，则将 插入节点 插入
    	if (root == null) {
			return new TreeNode(val);
		}
    	// 若当前节点的值小于 所插入的值，则将插入节点插入到当前位置，
    	// 当前节点变成插入节点的左子树，因为原来的树节点在插入节点的左边
    	if (root.val < val) {
    		TreeNode insertNode = new TreeNode(val);
			insertNode.left = root;
			return insertNode;
		}
    	// 若当前节点的值大于 所插入的值，则继续向右子树遍历
    	root.right = insertIntoMaxTree(root.right, val);
    	return root;
    }
}
