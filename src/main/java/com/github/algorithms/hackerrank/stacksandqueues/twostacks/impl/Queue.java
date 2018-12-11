package com.github.algorithms.hackerrank.stacksandqueues.twostacks.impl;

public interface Queue<T> {

    T enqueue(T e);

    T dequeue();

    T peek();
}
