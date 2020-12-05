public class ListNodeStack {
    ListNode head;

    public ListNodeStack() {
        this.head = new ListNode();
    }

    public void push(int data) {
        head.add(head, new ListNode(data), head.length());
    }

    public int pop() {
        ListNode removedNode = head.remove(head, head.length() - 1);
        return removedNode.value;
    }

}
