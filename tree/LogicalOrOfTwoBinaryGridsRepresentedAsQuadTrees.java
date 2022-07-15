package tree;

public class LogicalOrOfTwoBinaryGridsRepresentedAsQuadTrees {
	// leetcode 558 medium 2022/7/15
	public Node intersect(Node quadTree1, Node quadTree2) {
        //quadTree1��Ҷ�ӽ��
        if(quadTree1.isLeaf) {
        	//ֵ��true
        	if (quadTree1.val) {
				return new Node(true,true,null,null,null,null);
			}
        	//ֵ����true
        	return quadTree2;
        }
       //quadTree2��Ҷ�ӽ��
        if (quadTree2.isLeaf) {
			if (quadTree2.val) {
				return new Node(true,true,null,null,null,null);
			}
			return quadTree1;
		}
       //������Ҷ�ӽ��
        Node topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
        Node topRight = intersect(quadTree1.topRight, quadTree2.topRight);
        Node bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
        Node bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
        //�ĸ��ӽڵ㶼��Ҷ�ӽ�㲢��ֵ��ͬ
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf 
                && topLeft.val == topRight.val && topLeft.val == bottomLeft.val && topLeft.val == bottomRight.val) {
            return new Node(topLeft.val, true, null, null, null, null);
        }
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
	
	class Node {
	    public boolean val;
	    public boolean isLeaf;
	    public Node topLeft;
	    public Node topRight;
	    public Node bottomLeft;
	    public Node bottomRight;

	    public Node() {}

	    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
	        val = _val;
	        isLeaf = _isLeaf;
	        topLeft = _topLeft;
	        topRight = _topRight;
	        bottomLeft = _bottomLeft;
	        bottomRight = _bottomRight;
	    }
	}
}
