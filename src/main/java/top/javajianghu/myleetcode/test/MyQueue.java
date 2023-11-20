package top.javajianghu.myleetcode.test;

import java.util.Stack;

public class MyQueue {
    private Stack<Integer> firstStack = new Stack<>();
    private Stack<Integer> secondStack = new Stack<>();

    public MyQueue() {

    }

    // 将元素 x 推到队列的末尾
    public void push(int x) {
        while (!secondStack.isEmpty()) {
            firstStack.push(secondStack.pop());
        }
        firstStack.push(x);
    }

    //  从队列的开头移除并返回元素
    public int pop() {
        // 把firstStack的全部元素都倒腾到secondStack中
        while (!firstStack.isEmpty()) {
            secondStack.push(firstStack.pop());
        }
        return secondStack.pop();
    }

    // 返回队列开头的元素
    public int peek() {
        while (!firstStack.isEmpty()) {
            secondStack.push(firstStack.pop());
        }
        return secondStack.peek();
    }

    // 如果队列为空，返回 true ；否则，返回 false
    public boolean empty() {
        return firstStack.isEmpty() && secondStack.isEmpty();
    }
}