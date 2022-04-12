class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        //因为删除的节点不可能时末尾节点，所以使用，数值交换法进行删除
        ListNode rear = node.next; //rear节点必不可能是空节点
        int tempVal = node.val; //可以优化，由于要删除节点，所以不必更改rear.val的值
        node.val = rear.val;
        rear.val = tempVal;
        node.next = rear.next;
    }
}
