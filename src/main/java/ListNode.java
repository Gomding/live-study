public class ListNode {

    ListNode head; // 머리노드
    ListNode next; // 현재 선택 노드
    Integer value; // 값
    private int length = 0;

    public ListNode() {
        this.head = this;
    }

    public ListNode(int value) {
        this.value = value;
    }

    ListNode add(ListNode head, ListNode nodeToAdd, int position) {
        if (position == 0) {
            if (head.next == null) {
                head.next = nodeToAdd;
                length++;
                return nodeToAdd;
            }
        }

        if (!checkAvailablePosition(position - 1)) {
            System.out.println("Out of ListNode range");
            return null;
        }
        ListNode currentNode = head;

        for (int i = 0; i < position; i++) {
            currentNode = currentNode.next;
        }

        nodeToAdd.next = currentNode.next;
        currentNode.next = nodeToAdd;
        this.length++;
        return nodeToAdd;
    }

    ListNode remove(ListNode head, int positionToRemove) {
        if (!checkAvailablePosition(positionToRemove)) {
            System.out.println("Out of ListNode range");
            return null;
        }

        ListNode currentNode = head;

        for (int i = 0; i < positionToRemove; i++) {
            currentNode = currentNode.next;
        }
        ListNode deleteNode = currentNode.next;
        currentNode.next = currentNode.next.next;
        length--;
        return deleteNode;
    }

    boolean contains(ListNode head, ListNode nodeToCheck) {
        ListNode currentNode = head.next;
        for (int i = 0; i < length(); i++) {
            if (currentNode.value == nodeToCheck.value) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    private boolean checkAvailablePosition(int position) {
        if (position > length - 1 || position < 0) {
            System.out.println("Out of ListNode range");
            return false;
        }
        return true;
    }

    public int length() {
        return length;
    }

    @Override
    public String toString() {
        ListNode currentNode = head.next;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < length; i++) {
            sb.append(currentNode.value + ", ");
            currentNode = currentNode.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
