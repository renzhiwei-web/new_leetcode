package math;

import java.util.Arrays;

public class ErectTheFence {
	// leetcode 587 hard 2022/4/23
	// 二维凸包问题，此题解为Andrew算法
	// 暂时无法理解
	public int[][] outerTrees(int[][] trees) {
		// 首先对所有点进行双关键排序，先根据x坐标升序，后根据y升序
		// 根据x排升序的目的，是为了我们能够往一个方向画出凸包边缘（从左往右画出一半凸壳，从右往左画出另一半）
		// 对y升序目的是可以确保一旦我们现在从a到b进行连线，那么a到b之间的所有点能够确保被围住

		Arrays.sort(trees, (a, b) -> {
			return a[0] != b[0] ? a[0] - b[0] : a[1] - b[1];
		});
		// 使用栈来维护所有凸包上的点，准确的来说，由于凸包起点元素会再栈中出现两次（首尾），因此应该是使用栈维护凸包的所有边，栈中的相邻元素代表凸包的一条边
		int n = trees.length, top = 0;// top指栈的顶点
		int[] stk = new int[n + 10];
		boolean[] vis = new boolean[n + 10];
		stk[++top] = 0;

		for (int i = 1; i < n; i++) {
			int[] c = trees[i];
			while (top >= 2) {
				int[] a = trees[stk[top - 1]], b = trees[stk[top]];
				if (getArea(a, b, c) < 0) {
					vis[stk[top--]] = false;
				} else {
					break;
				}
			}
			stk[++top] = i;
			vis[i] = true;
		}
		int size = top;
		for (int i = n - 1; i >= 0; i--) {
			if (vis[i]) {
				continue;
			}
			int[] c = trees[i];
			while (top > size) {
				int[] a = trees[stk[top - 1]], b = trees[stk[top]];
				if (getArea(a, b, c) < 0) {
//    				vis[stk[top--]] = false;
					top--;
				} else {
					break;
				}

			}
			stk[++top] = i;
			vis[i] = true;
		}
		int[][] ans = new int[top - 1][2];
		for (int i = 1; i < top; i++) {
			ans[i - 1] = trees[stk[i]];
		}
		return ans;
	}

	private int[] subtraction(int[] a, int[] b) {// 向量相减
		return new int[] { a[0] - b[0], a[1] - b[1] };
	}

	private double cross(int[] a, int[] b) {// 叉乘
		return a[0] * b[1] - a[1] * b[0];
	}

	private double getArea(int[] a, int[] b, int[] c) {// 向量ab转为向量ac过程中扫过的面积
		return cross(subtraction(b, a), subtraction(c, a));
	}
}
