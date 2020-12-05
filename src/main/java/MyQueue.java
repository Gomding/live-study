public class MyQueue {
    int capacity;
    int front;
    int rear;
    int size;
    int[] queue;

    MyQueue(int capacity) {
        this.capacity = capacity;
        size = 0;
        front = 0;
        rear = 0;
        queue = new int[capacity];
    }

    public void offer(int data) {
        if (size >= capacity) {
            throw new OverflowQueueException();
        }
        queue[rear++] = data;
        size++;

        if (rear == capacity) {
            rear = 0;
        }
    }

    public int poll() {
        if (size <= 0) {
            throw new EmptyQueueException();
        }
        size--;
        int num = queue[front++];

        if (front == capacity) {
            front = 0;
        }

        return num;
    }

}

class EmptyQueueException extends RuntimeException {}

class OverflowQueueException extends RuntimeException {}
