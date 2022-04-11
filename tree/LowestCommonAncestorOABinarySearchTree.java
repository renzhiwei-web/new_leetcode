class LowestCommonAncestorOABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 注意这是二叉排序树，利用二叉排序树的性质
        TreeNode ancestor = root;
        while(true){
            if(p.val > ancestor.val && q.val > ancestor.val){
                ancestor = ancestor.right;
            }else if(p.val < ancestor.val && q.val < ancestor.val){
                ancestor = ancestor.left;
            }else{
                break;
            }
        }
        return ancestor;
    }
}
