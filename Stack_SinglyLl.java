/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.stack_singlyll;

/**
 *
 * @author PMYLS
 */
public class Stack_SinglyLl {



class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}


    private Node front;
    private Node rear;

    public Stack_SinglyLl() {
        front = null;
        rear = null;
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println("Enqueued: " + data);
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Nothing to dequeue.");
            return -1;
        } else {
            int data = front.data;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            System.out.println("Dequeued: " + data);
            return data;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Nothing to peek.");
            return -1;
        } else {
            return front.data;
        }
    }

    public boolean isEmpty() {
        return front == null;
    }

    public static void main(String[] args) {
       Stack_SinglyLl q = new Stack_SinglyLl();
        q.enqueue(10);
        q.enqueue(20);
        System.out.println("Peek: " + q.peek());
        q.dequeue();
        System.out.println("Peek: " + q.peek());
        q.dequeue();
        q.dequeue();
    }
}

