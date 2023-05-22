package tree;

public class InsufficientNodesInRootToLeafPaths {
    // leetcode 1080 medium 2023/5/22
    // 分治算法，利用dfs的后序遍历，先判断子树问题，再判断父问题
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        boolean rootDeleted = dfs(root,0,limit);
        if (rootDeleted) {
            return null;
        }
        return root;
    }

    // 返回 node 结点是否被删除
    private boolean dfs(TreeNode node, int s, int limit) {
        if (node.left == null && node.right == null){
            return s + node.val < limit;
        }
        boolean lTreeDeleted = true;
        boolean rTreeDeleted = true;
        // 如果有左子树，就先递归处理左子树
        if (node.left != null) {
            lTreeDeleted = dfs(node.left,s + node.val,limit);
        }
        // 如果有右子树，就先递归处理右子树
        if (node.right != null) {
            rTreeDeleted = dfs(node.right,s + node.val,limit);
        }
        // 左右子树是否保留的结论得到了，由自己来执行是否删除它们
        if (lTreeDeleted){
            node.left = null;
        }
        if (rTreeDeleted) {
            node.right = null;
        }
        // 只有左右子树都被删除了，自己才没有必要保留
        return lTreeDeleted && rTreeDeleted;
    }
}
