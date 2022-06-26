package engineerkorea.stack;

import java.util.EmptyStackException;

/*
 * pop()
 * push()
 * peek()
 * isEmpty()
 *
 * https://www.youtube.com/watch?v=whVUYv0Leg0
 */
class Stack<T> {
    class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> top;

    public T pop() {
        if( top == null) {
            throw new EmptyStackException();
        }

        // 맨위에꺼를 반환하기 전에 백업하고, 다음꺼를 top으로 만들어 준다
        T item = top.data;
        top = top.next;
        return item;
    }

    public void push(T item) {
        Node<T> t = new Node<T>(item);
        t.next = top;
        top = t;
    }

    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
public class Test {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
    }
}
