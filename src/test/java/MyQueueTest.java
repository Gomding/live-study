import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyQueueTest {

    MyQueue queue;

    @BeforeEach
    public void MyQueue_객체생성() {
        queue = new MyQueue(10);
    }

    @Test
    public void offer_된다() {
        queue.offer(10);
        assertEquals(queue.size, 1);
    }

    @Test
    public void poll_된다() {
        queue.offer(10);
        assertEquals(queue.poll(), 10);
    }

    @Test
    public void OverflowQueueException_발생한다() {
        Exception exception = assertThrows(OverflowQueueException.class,
                () -> {
                    for (int i = 0; i < 50; i++) {
                        queue.offer(i);
                    }
                });
    }

    @Test
    public void EmptyQueueException_발생한다() {
        Exception exception = assertThrows(EmptyQueueException.class,
                () -> queue.poll());
    }

}
