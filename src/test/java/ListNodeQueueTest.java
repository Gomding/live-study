import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ListNodeQueueTest {
    ListNodeQueue listNodeQueue;

    @BeforeEach
    public void ListNodeQueue_객체생성() {
        listNodeQueue = new ListNodeQueue();
    }

    @Test
    public void offer_된다() {
        listNodeQueue.offer(10);
        assertEquals(listNodeQueue.head.length(), 1);
        assertTrue(listNodeQueue.head.contains(listNodeQueue.head, new ListNode(10)));
    }

    @Test
    public void poll_된다() {
        listNodeQueue.offer(10);
        int num = listNodeQueue.poll();
        assertEquals(num, 10);
        assertTrue(listNodeQueue.head.length() == 0);
    }

}
