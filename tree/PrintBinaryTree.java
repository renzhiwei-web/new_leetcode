package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintBinaryTree {
	// leetcode 655 medium 2022/8/22
	// ��ͨ��dfs��ȡ�����ĸ߶ȣ��ٹ�������������ͨ��dfs���������о�������
	public List<List<String>> printTree(TreeNode root) {
		// ��ȡ�߶�
		int height = getHeight(root);
		String[][] ans = new String[height][(1 << height) - 1];
		for (String[] arr : ans) {
			Arrays.fill(arr, "");
		}
		List<List<String>> res = new ArrayList<>();
		fill(ans, root, 0, 0, ans[0].length);
		for (String[] arr : ans) {
			res.add(Arrays.asList(arr));
		}
		return res;
	}

	/**
	 * �������
	 *
	 * @param ans  ����
	 * @param root ���ڵ�
	 * @param i    �ڼ���
	 * @param l    ��ڵ�
	 * @param r    �ҽڵ�
	 */
	private void fill(String[][] ans, TreeNode root, int i, int l, int r) {
		if (root == null) {
			return;
		}
		ans[i][(l + r) / 2] = "" + root.val;
		fill(ans, root.left, i + 1, l, (l + r) / 2); // ��ÿ���ڵ㿴�ɸ��ڵ㣬���ڵ���ÿһ������ĵ�
		fill(ans, root.right, i + 1, (l + r + 1) / 2, r);
	}

	/**
	 * ��ȡ���ĸ߶�
	 *
	 * @param root
	 * @return
	 */
	private int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}

}
