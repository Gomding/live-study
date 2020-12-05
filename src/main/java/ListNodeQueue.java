public class ListNodeQueue {
    ListNode head;

    ListNodeQueue() {
        this.head = new ListNode();
    }

    public void offer(int data) {
        head.add(head, new ListNode(data), head.length());
    }

    public int poll() {
        ListNode removedNode = head.remove(head, 0);
        return removedNode.value;
    }
}
