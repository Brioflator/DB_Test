package org.example.Ordered;

class Node {
    int data;
    Node prev, next;

    // Function to get a new node
    static Node getNode(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.prev = newNode.next = null;
        return newNode;
    }
}
