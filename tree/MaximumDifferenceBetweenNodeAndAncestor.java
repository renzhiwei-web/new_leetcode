package tree;

public class MaximumDifferenceBetweenNodeAndAncestor {
    int ans = 0;
    public int maxAncestorDiff(TreeNode root) {
        // 直接递归时间复杂度大
//        dfs(root,root,ans);
//        return ans;

        dfs(root,root.val, root.val);
        return ans;
    }

    private void dfs(TreeNode root, TreeNode child, int max) {
        if (root == null) {
            return;
        }
        if (child == null){
            dfs(root.left,root.left,ans);
            dfs(root.right,root.right,ans);
        }else {
            ans = Math.max(max, Math.abs(root.val - child.val));
            dfs(root, child.left, ans);
            dfs(root, child.right, ans);
        }
    }

    private void dfs(TreeNode root,int max,int min){
        if (root == null) {
            ans = Math.max(ans,max - min);
            return;
        }
        max = Math.max(max,root.val);
        min = Math.min(min,root.val);
        dfs(root.left,max,min);
        dfs(root.right,max,min);
    }

}
