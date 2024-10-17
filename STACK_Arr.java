/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.stack_arr;

/**
 *
 * @author PMYLS
 */


public class STACK_Arr {
    private int[] queue;
    private int front;
    private int rear;
    private int size;

    public STACK_Arr(int capacity) {
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int data) {
        if (size == queue.length) {
            System.out.println("Queue is full. Cannot enqueue " + data);
        } else {
            rear = (rear + 1) % queue.length;
            queue[rear] = data;
            size++;
            System.out.println("Enqueued: " + data);
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Nothing to dequeue.");
            return -1;
        } else {
            int data = queue[front];
            front = (front + 1) % queue.length;
            size--;
            System.out.println("Dequeued: " + data);
            return data;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Nothing to peek.");
            return -1;
        } else {
            return queue[front];
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        STACK_Arr q = new STACK_Arr(5);
        q.enqueue(10);
        q.enqueue(20);
        System.out.println("Peek: " + q.peek());
        q.dequeue();
        System.out.println("Peek: " + q.peek());
        q.dequeue();
        q.dequeue();
    }
}


