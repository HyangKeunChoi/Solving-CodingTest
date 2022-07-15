package engineerkorea.queue;

import java.util.NoSuchElementException;

// https://www.youtube.com/watch?v=W3jNbNGyjMs&list=PLjSkJdbr_gFZL2BNnGLvTgMYXptKGIyum&index=2
// FIFO
// add
// remove
// peek
// isEmpty
public class Test {
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.peek());
        System.out.println("q.remove() = " + q.remove());
        System.out.println(q.isEmpty());
        System.out.println(q.remove());
        System.out.println(q.isEmpty());
    }
}
class Queue<T> {

    class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> first;
    private Node<T> last;

    public void add(T item) {
        Node<T> t = new Node<T>(item);

        if(last != null) {
            last.next = t;
        }
        last = t;
        if(first == null) {
            first = last;
        }
    }

    public T remove() {
        if(first == null) {
            throw new NoSuchElementException();
        }
        T data = first.data;
        first = first.next;

        // first가 null이됐을때
        // last도 null로 변경
        if(first == null) {
            last = null;
        }
        return data;
    }

    public T peek() {
        if(first == null) {
            throw new NoSuchElementException();
        }
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }
}
