package leetcode;

import java.util.*;

/**
 * 题干：用栈实现队列
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * 实现 MyQueue 类：
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * ******************************************************
 * 解法：
 * ******************************************************
 * 原题：<a href="https://leetcode.cn/problems/implement-queue-using-stacks/"></a>
 * ******************************************************
 */
class Q232 {
    Stack<Integer> in;
    Stack<Integer> out;
    public Q232() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        if (!out.isEmpty()){
            return out.pop();
        }
        if (!in.isEmpty()){
            in2out();
            return out.pop();
        }
        return -1;
    }

    public int peek() {
        if (!out.isEmpty()){
            return out.peek();
        }
        if (!in.isEmpty()){
            in2out();
            return out.peek();
        }
        return -1;
    }

    public boolean empty() {
        if (in.isEmpty() && out.isEmpty())
            return true;
        return false;
    }

    public void in2out(){
        while (!in.isEmpty())
            out.push(in.pop());
    }
}
