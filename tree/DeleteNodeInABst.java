package tree;

public class DeleteNodeInABst {
	// leetcode 450 medium 2022/6/2
	// 难点在于递归的理解
    public TreeNode deleteNode(TreeNode root, int key) {
    	if (root == null) {
			return root;
		}
    	if (key > root.val) {
			root.right = deleteNode(root.right, key);
		}else if (key < root.val) {
			root.left = deleteNode(root.left, key);
		}else {
			if (root.right == null) {
				return root.left;
			}
			if (root.left == null) {
				return root.right;
			}
			// 当删除节点左右子节点都在时，有两种删除方法
			// 这里用右子树最小节点替换方法
			TreeNode node = root.right;
			while(node.left != null) {
				node = node.left;
			}
			// 一种简单的方法
			// 将删除的节点root的左子树成为node节点的左子树
			node.left = root.left;
			// 删除节点root的右节点成为根
			root = root.right;
			// 另一种方法,将node的val赋值于root，再删除node
			// root.val = node.val;
			// deleteNode(root.right, node.val);
		}
    	return root;
    }
}
