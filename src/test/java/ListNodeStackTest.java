import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ListNodeStackTest {

    ListNodeStack listNodeStack;

    @BeforeEach
    public void ListNodeStack_객체생성() {
        listNodeStack = new ListNodeStack();
    }

    @Test
    public void push_된다() {
        listNodeStack.push(10);
        assertEquals(listNodeStack.head.length(), 1);
    }

    @Test
    public void pop_된다() {
        listNodeStack.push(10);
        assertEquals(listNodeStack.pop(), 10);
    }
}
