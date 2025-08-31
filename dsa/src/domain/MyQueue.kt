package domain

import java.util.Stack

class MyQueue() {
    val pushStack = Stack<Int>()
    val popStack = Stack<Int>()

    fun push(x: Int) {
        pushStack.push(x)
    }

    fun pop(): Int {
        peek()
        return popStack.pop()
    }

    fun peek(): Int {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.add(pushStack.pop())
            }
        }
        return popStack.peek()
    }

    fun empty(): Boolean {
        return pushStack.isEmpty() && popStack.isEmpty()
    }
}