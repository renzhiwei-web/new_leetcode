package tree;

public class EvaluateBooleanBinaryTree {
    public boolean evaluateTree(TreeNode root) {
        // leetcode 2331 simple 2023/2/6
        // 简单递归模拟
        if (root.left == null && root.right == null){
            return root.val == 1;
        }
        if (root.val == 2){
            return evaluateTree(root.left) || evaluateTree(root.right);
        }else {
            return evaluateTree(root.left) && evaluateTree(root.right);
        }
    }
}
