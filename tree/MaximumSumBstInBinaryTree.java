package tree;

public class MaximumSumBstInBinaryTree {
    // leetcode 1373 hard 2023/5/20
    // 如何判断二叉树是否是二叉搜索树
    private int ans;
    private final int inf = 1 << 30;
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{1,inf,-inf,0};
        }
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        int val = root.val;
        // root 节点是否满足二叉搜索树的条件：
        if (l[0] == 1 && r[0] == 1 && l[2] < val && r[1] > val){
            int s = val + l[3] + r[3];
            ans = Math.max(ans,s);
            return new int[]{1,Math.min(l[1],val),Math.max(r[2],val),s};
        }
        return new int[4];
    }
}
