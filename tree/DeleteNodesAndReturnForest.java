package tree;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest {
    // leetcode 1110 medium 2023/5/30
    // 使用哈希表来快速判断节点值是否在todelete中
    // 采用后序遍历的方式进行删除节点
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        int len = to_delete.length;
        List<TreeNode> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>(len);
        for (int x : to_delete) {
            set.add(x);
        }
        if (dfs(list,set,root) != null){
            // 如果根节点没被删除，把根节点加入答案。
            list.add(root);
        }
        return list;
    }

    private TreeNode dfs(List<TreeNode> list, Set<Integer> set, TreeNode node) {
        if (node == null){
            return null;
        }
        // 更新左儿子（右儿子）为递归左儿子（右儿子）的返回值。
        node.left = dfs(list,set,node.left);
        node.right = dfs(list,set,node.right);
        if (!set.contains(node.val)){
            return node;
        }
        // 如果当前节点被删除，那么就检查左儿子（右儿子）是否被删除，如果没被删除，就加入答案。
        if (node.left != null) {
            list.add(node.left);
        }
        if (node.right != null) {
            list.add(node.right);
        }
        // 如果当前节点被删除，返回空节点，否则返回当前节点。
        return null;
    }
}
