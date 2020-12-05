import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyStackTest {

    MyStack stack;

    @BeforeEach
    public void MyStack_객체생성() {
        stack = new MyStack(10);
    }

    @Test
    public void push_작동한다() {
        stack.push(10);
        assertEquals(stack.pointer, 1);
    }

    @Test
    public void pop_작동한다() {
        stack.push(10);
        assertEquals(stack.pop(), 10);
        assertEquals(stack.pointer, 0);
    }

    @Test
    public void OverflowStackException_발생한다() {
        Exception exception = assertThrows(OverflowStackException.class,
                () -> {
                    for (int i = 0; i < 50; i++) {
                        stack.push(i);
                    }
                });
    }

    @Test
    public void EmptyStackException_발생한다() {
        Exception exception = assertThrows(EmptyStackException.class,
                () -> stack.pop());
    }


}
