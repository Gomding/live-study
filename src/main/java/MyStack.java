public class MyStack {
    int[] stack;
    int capacity;
    int pointer;

    public MyStack(int capacity) {
        this.capacity = capacity;
        pointer = 0;
        try {
            stack = new int[capacity];
        }catch (OutOfMemoryError e) {
            capacity = 0;
        }
    }

    public void push(int data) throws OverflowStackException{
        if (pointer >= capacity) {
            throw new OverflowStackException();
        }
        stack[pointer++] = data;
    }

    public int pop() throws EmptyStackException{
        if (pointer <= 0) {
            throw new EmptyStackException();
        }
        return stack[--pointer];
    }
}

class EmptyStackException extends RuntimeException {
}

class OverflowStackException extends RuntimeException {

}
