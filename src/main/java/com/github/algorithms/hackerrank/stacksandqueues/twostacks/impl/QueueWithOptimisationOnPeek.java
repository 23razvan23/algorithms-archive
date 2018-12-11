package com.github.algorithms.hackerrank.stacksandqueues.twostacks.impl;

import java.util.EmptyStackException;
import java.util.Stack;

public class QueueWithOptimisationOnPeek<T> implements Queue<T> {
    private Stack<T> additions = new Stack<>();
    private Stack<T> removals = new Stack<>();
    //optimisation to avoid stacks reversals for peek operation
    private T top;

    @Override
    public T enqueue(T e) {
        if (additions.empty()) {
            try {
                top = removals.peek();
            } catch (EmptyStackException ex) {
                top = e;
            }
        }

        reverseStacks(additions, removals);

        return additions.push(e);
    }

    @Override
    public T dequeue() {
        reverseStacks(removals, additions);

        T top = removals.pop();

        try {
            this.top = removals.peek();
        } catch (EmptyStackException e) {
            // no more elements in the stacks
            this.top = null;
        }

        return top;
    }

    @Override
    public T peek() {
        return top;
    }

    private void reverseStacks(Stack<T> first, Stack<T> second) {
        while (!second.empty()) {
            first.push(second.pop());
        }
    }
}
