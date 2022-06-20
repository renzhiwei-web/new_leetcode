package designClass;

// leetcode 715 hard 2022/6/20
// ��Ҫʹ���߶�����ѧϰ���߶��������Ƕ���lazy��ǻ��ǲ��Ǻ��������Ҫ�ٽ�һ�������
public class RangeModule {
	
	// �߶����Ľڵ�
	static class Node{
		// ��Χ
		private int leftX;
		// �ҷ�Χ
		private int rightX;
		// �����
		private int sum;
		// 0��ʾɾ����1��ʾ��ӣ�2��ʾ�޸���
		private int lazy;
		// ��������������
		Node leftChild,rightChild;
		
		public Node(int leftX,int rightX) {
			this.leftX = leftX;
			this.rightX = rightX;
		}
	}
	
	private Node root;
	
	/**
	 * �������
	 * 
	 * @param root 
	 * @param left ���ұ߽�
	 * @param right
	 * @param value ����ֵ��ɾ���൱������0
	 */
	public void update(Node root,int left,int right,int value) {
		// ���ڷ�Χ�ڣ�ֱ�ӷ���
		if (root.leftX > right || root.rightX < left) {
			return;
		}
		// �޸ĵ����������ǰ�ڵ�
		if (root.leftX >= left && root.rightX <= right) {
			root.lazy = value;
			root.sum = (root.rightX - root.leftX + 1) * value;
		}else {// �޸ĵ������뵱ǰ�ڵ��ʾ�������н��������ǲ���ȫ����
			// ��̬����
			lazyCreate(root);
			// �´�lazy
			pushDown(root);
			// ����������
			update(root.leftChild, left, right, value);
			// ����������
			update(root.rightChild, left, right, value);
			// �ϴ������Ҳ���������
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
	 * ������������
	 * @param root
	 */
	public void lazyCreate(Node root) {
		// �����������������������ڵ������Ӧ����ͬ����������������������һ���ڵ�
		if (root.leftChild == null) {
			root.leftChild = new Node(root.leftX, root.leftX + (root.rightX - root.leftX) / 2);
		}
		if (root.rightChild == null) {
			root.rightChild = new Node(root.leftX+(root.rightX - root.leftX) / 2 + 1,root.rightX);
		}
	}
	
	public void pushDown(Node root) {
		// ����ֻ����һ���ӽڵ�
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
