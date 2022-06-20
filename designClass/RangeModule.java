package designClass;

// leetcode 715 hard 2022/6/20
// 需要使用线段树，学习了线段树，但是对于lazy标记还是不是很清楚，需要再进一步的理解
public class RangeModule {
	
	// 线段树的节点
	static class Node{
		// 左范围
		private int leftX;
		// 右范围
		private int rightX;
		// 区间和
		private int sum;
		// 0表示删除，1表示添加，2表示无更新
		private int lazy;
		// 左子树与右子树
		Node leftChild,rightChild;
		
		public Node(int leftX,int rightX) {
			this.leftX = leftX;
			this.rightX = rightX;
		}
	}
	
	private Node root;
	
	/**
	 * 区间更新
	 * 
	 * @param root 
	 * @param left 左右边界
	 * @param right
	 * @param value 更新值，删除相当于置于0
	 */
	public void update(Node root,int left,int right,int value) {
		// 不在范围内，直接返回
		if (root.leftX > right || root.rightX < left) {
			return;
		}
		// 修改的区间包含当前节点
		if (root.leftX >= left && root.rightX <= right) {
			root.lazy = value;
			root.sum = (root.rightX - root.leftX + 1) * value;
		}else {// 修改的区间与当前节点表示的区间有交集，但是不完全包含
			// 动态开点
			lazyCreate(root);
			// 下传lazy
			pushDown(root);
			// 更新左子树
			update(root.leftChild, left, right, value);
			// 更新右子树
			update(root.rightChild, left, right, value);
			// 上传结果，也就是区间和
			pushUp(root);
		}
	}
	
	public int query(Node root,int left,int right) {
		if (left <= root.leftX && root.rightX <= right) {
			return root.sum;
		}
		lazyCreate(root);
		pushDown(root);
		int mid = root.leftX + (root.rightX - root.leftX) / 2;
		if (right <= mid) {
			return query(root.leftChild, left, right);
		}else if (left > mid) {
			return query(root.rightChild, left, right);
		}else {
			return query(root.leftChild, left, mid) + query(root.rightChild, mid + 1, right);
		}
	}
	/**
	 * 创建左右子树
	 * @param root
	 */
	public void lazyCreate(Node root) {
		// 创建左右子树，左右子树节点的区间应该相同，或者左子树比右子树多一个节点
		if (root.leftChild == null) {
			root.leftChild = new Node(root.leftX, root.leftX + (root.rightX - root.leftX) / 2);
		}
		if (root.rightChild == null) {
			root.rightChild = new Node(root.leftX+(root.rightX - root.leftX) / 2 + 1,root.rightX);
		}
	}
	
	public void pushDown(Node root) {
		// 向下只创建一层子节点
		if (root.lazy == 2) {
			return;
		}
		int value = root.lazy;
		root.leftChild.lazy = value;
		root.rightChild.lazy = value;
		root.leftChild.sum = (root.leftChild.rightX - root.leftChild.leftX + 1) * value;
		root.rightChild.sum = (root.rightChild.rightX - root.rightChild.leftX + 1) * value;
		root.lazy = 2;
	}
	
	public void pushUp(Node root) {
		root.sum = root.leftChild.sum + root.rightChild.sum;
	}
	
	
    public RangeModule() {
    	root = new Node(0, (int)(1e9));
    }
    
    public void addRange(int left, int right) {
    	update(root, left, right - 1, 1);
    }
    
    public boolean queryRange(int left, int right) {
    	return (right - left) == query(root, left, right - 1);
    }
    
    public void removeRange(int left, int right) {
    	update(root, left, right - 1, 0);
    }
}
