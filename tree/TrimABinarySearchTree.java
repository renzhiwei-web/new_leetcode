package tree;

public class TrimABinarySearchTree {
	// leetcode 669 medium 2022/9/10
	// bstµÄÉ¾³ý
    public TreeNode trimBST(TreeNode root, int low, int high) {
    	if (root == null) {
			return null;
		}
    	if (root.val < low) {
			return trimBST(root.right, low, high);
		}else if(root.val > high){
			return trimBST(root.left, low, high);
		}else {
			root.left = trimBST(root.left, low, high);
			root.right = trimBST(root.right, low, high);
			return root;
		}
    }
}
