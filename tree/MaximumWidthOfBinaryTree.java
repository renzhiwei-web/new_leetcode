package tree;

import java.util.HashMap;
import java.util.Map;

public class MaximumWidthOfBinaryTree {
	// leetcode 662 medium 2022/8/27
	// ������ɵ�ʹ��bfs��������Ҫ����սڵ㣬�������ö�����������
	Map<Integer, Integer> levelMin = new HashMap<Integer, Integer>();

    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 1, 1);
    }

    public int dfs(TreeNode node, int depth, int index) {
        if (node == null) {
            return 0;
        }
        levelMin.putIfAbsent(depth, index); // ÿһ�����ȷ��ʵ��Ľڵ��������ߵĽڵ㣬��ÿһ���ŵ���Сֵ
        return Math.max(index - levelMin.get(depth) + 1, Math.max(dfs(node.left, depth + 1, index * 2), dfs(node.right, depth + 1, index * 2 + 1)));
    }
}
