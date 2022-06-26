package baekjoon.step.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;

public class Solution1_stack {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        Stack<Integer> stack = new Stack<>();

        Integer i = Integer.valueOf(line);
        for (int j = 0; j < i; j++) {

            BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
            String line2 = br2.readLine();

            if(line2.contains("push")) {
                String[] s = line2.split(" ");
                stack.push(Integer.parseInt(s[1]));
            }

            if(line2.contains("top")) {
                System.out.println(stack.peek());
            }

            if(line2.contains("size")) {
                System.out.println(stack.size());
            }
            if(line2.contains("empty")) {
                stack.isEmpty();
            }
            if(line2.contains("pop")) {
                System.out.println(stack.pop());
            }
        }

    }
}

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

    public void isEmpty() {
        if(top == null) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public int size() {
        int count = 0;

        while(top == null) {
            top = top.next;
            count++;
        }
        return count;
    }
}
