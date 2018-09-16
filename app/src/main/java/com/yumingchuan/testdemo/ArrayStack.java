package com.yumingchuan.testdemo;

/**
 * Created by yumingchuan on 2018/9/14.java用数组实现栈
 */

public class ArrayStack {

    private int[] arrInt;
    private int top;

    private ArrayStack() {

    }

    public ArrayStack(int size) {
        this.top = -1;
        this.arrInt = new int[size];
    }

    public boolean isEmpty() {
        return -1 == top;
    }

    public boolean isFull() {
        return arrInt.length - 1 == top;
    }

    public void push(int item) {
        if (!isFull()) {
            arrInt[++top] = item;
        } else {
            throw new RuntimeException("stack is full");
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        } else {
            return arrInt[top--];
        }
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        } else {
            return arrInt[top];
        }
    }


}
