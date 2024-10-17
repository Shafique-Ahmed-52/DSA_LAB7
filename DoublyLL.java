/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.doubly.ll;

/**
 *
 * @author PMYLS
 */
public class DoublyLL {
class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}


    private Node head;
    private Node tail;

    public DoublyLL () {
        head = null;
        tail = null;
    }

    
    public void addAtStart(int data) {
        Node newNode = new Node(data);
        if (head == null) { 
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addAtEnd(int data) {
        Node newNode = new Node(data);
        if (tail == null) { 
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void addAtPosition(int data, int position) {
        if (position < 0) {
            System.out.println("Invalid position!");
            return;
        }
        Node newNode = new Node(data);
        if (position == 0) {
            addAtStart(data);
            return;
        }

        Node current = head;
        for (int i = 0; i < position - 1; i++) {
            if (current == null) {
                System.out.println("Position out of bounds!");
                return;
            }
            current = current.next;
        }

        if (current == null || current == tail) {
            addAtEnd(data);
        } else {
            newNode.next = current.next;
            newNode.prev = current;
            if (current.next != null) {
                current.next.prev = newNode;
            }
            current.next = newNode;
        }
    }

   
    public void deleteFromStart() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (head == tail) { 
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    public void deleteFromEnd() {
        if (tail == null) {
            System.out.println("List is empty!");
            return;
        }
        if (head == tail) { 
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    public void deleteByValue(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                if (current == head) {
                    deleteFromStart();
                } else if (current == tail) {
                    deleteFromEnd();
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                return;
            }
            current = current.next;
        }
        System.out.println("Value " + data + " not found!");
    }

    
    public void displayFromStart() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("None");
    }

    public void displayFromEnd() {
        if (tail == null) {
            System.out.println("List is empty!");
            return;
        }
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }
        System.out.println("None");
    }

   
    public void search(int value) {
        Node current = head;
        int position = 0;
        while (current != null) {
            if (current.data == value) {
                System.out.println("Value " + value + " found at position " + position);
                return;
            }
            current = current.next;
            position++;
        }
        System.out.println("Value " + value + " not found!");
    }

    
    public void reverse() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        Node current = head;
        Node temp = null;
        tail = current;
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if (temp != null) {
            head = temp.prev;
        }
    }

    
    public int countNodes() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public static void main(String[] args) {
        DoublyLL dll = new DoublyLL();
        
        dll.addAtStart(10);
        dll.addAtEnd(20);
        dll.addAtPosition(15, 1);
        dll.displayFromStart(); 
        
        dll.reverse();
        dll.displayFromStart();  
        
        System.out.println("Node count: " + dll.countNodes());  
        
        dll.search(15);  
        
        dll.deleteByValue(15);
        dll.displayFromStart();  
    }
}
