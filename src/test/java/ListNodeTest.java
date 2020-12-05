import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ListNodeTest {

    ListNode listNode;

    @BeforeEach
    public void listNode_객체생성() {
        listNode = new ListNode();
        listNode.add(listNode, new ListNode(3), 0);
    }

    @Test
    public void 노드_추가된다() {
        assertEquals(listNode.next.value, 3);
    }

    @Test
    public void 노드_삭제된다() {
        int beforeLengthToRemove = listNode.length();
        ListNode deleteNode = listNode.remove(listNode, 0);
        int afterLengthToRemove = listNode.length();
        assertEquals(deleteNode.value, 3);
        assertEquals(beforeLengthToRemove - 1, afterLengthToRemove);
    }

    @Test
    public void 노드검색() {
        assertTrue(listNode.contains(listNode, new ListNode(3)));
    }


}
