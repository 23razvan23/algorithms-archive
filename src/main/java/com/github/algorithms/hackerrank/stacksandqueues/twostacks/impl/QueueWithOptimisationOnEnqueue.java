package com.github.algorithms.hackerrank.stacksandqueues.twostacks.impl;

import java.util.Stack;

public class QueueWithOptimisationOnEnqueue<T> implements Queue<T> {
    private Stack<T> additions = new Stack<>();
    private Stack<T> removals = new Stack<>();

    @Override
    public T enqueue(T e) {
        return additions.push(e);
    }

    @Override
    public T dequeue() {
        rebalanceTop();
        return removals.pop();
    }

    @Override
    public T peek() {
        rebalanceTop();
        return removals.peek();
    }

    private void rebalanceTop() {
        if (removals.empty()) {
            while (!additions.empty()) {
                removals.push(additions.pop());
            }
        }
    }
}
