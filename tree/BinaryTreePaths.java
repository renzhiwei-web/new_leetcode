class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        //根据题意，容易得知使用树的深度优先算法，主要的思想是回溯法
        List<String> ans = new ArrayList<String>();
        bfs(root,"",ans);
        return ans;
    }

    public void dfs(TreeNode root,String path,List<String> ans){
        if (root == null){
            return;
        }
        StringBuffer pathSB = new StringBuffer(path);
        pathSB.append(Integer.toString(root.val));
        if(root.left == null && root.right == null){
            //已经加入叶子节点，将整条路径放入集合中。
            ans.add(pathSB.toString());
        }else{
            pathSB.append("->");//当前节点不是叶子节点，继续递归遍历；
            bfs(root.left,pathSB.toString(),ans);
            bfs(root.right,pathSB.toString(),ans);
        }
    }

    
}
