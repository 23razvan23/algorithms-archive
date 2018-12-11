package com.github.algorithms.hackerrank.stacksandqueues.twostacks;

import com.github.algorithms.hackerrank.stacksandqueues.twostacks.impl.Queue;
import com.github.algorithms.hackerrank.stacksandqueues.twostacks.impl.QueueWithOptimisationOnEnqueue;
import com.github.algorithms.hackerrank.stacksandqueues.twostacks.impl.QueueWithOptimisationOnPeek;

public class TwoStacks {

    public static void main(String[] args) {
        testcase1(new QueueWithOptimisationOnPeek<>());
        System.out.println();
        testcase1(new QueueWithOptimisationOnEnqueue<>());

        System.out.println();
        System.out.println();

        testcase2(new QueueWithOptimisationOnPeek<>());
        System.out.println();
        testcase2(new QueueWithOptimisationOnEnqueue<>());
    }

    private static void testcase1(Queue<Integer> queue) {
        queue.enqueue(12);
        queue.enqueue(14);

        //12
        System.out.println(queue.peek());

        queue.dequeue();

        //14
        System.out.println(queue.peek());

        queue.enqueue(71);
        queue.enqueue(63);

        //14
        System.out.println(queue.peek());
    }

    private static void testcase2(Queue<Integer> queue) {
        queue.enqueue(15);
        queue.enqueue(17);

        //15
        System.out.println(queue.peek());

        queue.enqueue(25);

        queue.dequeue();

        //17
        System.out.println(queue.peek());

        queue.dequeue();

        //25
        System.out.println(queue.peek());
    }
}
