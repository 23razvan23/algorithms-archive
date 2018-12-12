package com.github.algorithms.hackerrank.stacksandqueues.largestrectangle;

import java.util.ArrayDeque;
import java.util.Deque;

//each Rectangle (deque backed) will keep as first element the height and as the last element the rectangle size
public class Rectangle {
    private Deque<Integer> deque;

    Rectangle(Integer head) {
        deque = new ArrayDeque<>();
        deque.addFirst(head);
    }

    Integer height() {
        return deque.getFirst();
    }

    Integer size() {
        return deque.getLast();
    }

    void increaseSize() {
        deque.add(height() + size());
    }
}
