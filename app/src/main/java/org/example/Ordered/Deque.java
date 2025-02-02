package org.example.Ordered;

class Deque {

    Node front;
    Node rear;
    int size;

    Deque() {
        front = rear = null;
        size = 0;
    }

    /// Function to check whether deque is empty or not
    boolean isEmpty() {
        return (front == null);
    }

    /// Function to return the number of elements in the deque
    int getSize() {
        return size;
    }

    /// Function to insert an element at the rear end.
    /// Only inserting in the rear because the inserted item
    /// is always greater than maximum so far
    void insert(int data) {
        Node newNode = Node.getNode(data);
        // If deque is empty
        if (rear == null)
            front = rear = newNode;

        else {
            newNode.prev = rear;
            rear.next = newNode;
            rear = newNode;
        }

        size++;
    }

    /// Function to delete the element from the front end
    void extractMin() {
        //Can't extract if deque is empty
        if (isEmpty())
            throw new IllegalStateException("UnderFlow");
            // Deletes the node from the front end and makes the adjustment in the links
        else {
            front = front.next;

            // If only one element was present
            if (front == null)
                rear = null;
            else
                front.prev = null;

            size--;
        }
    }

    /// Function to delete the element from the rear end
    void extractMax() {
        //Can't extract if deque is empty
        if (isEmpty())
            throw new IllegalStateException("UnderFlow");
            // Deletes the node from the rear end and makes the adjustment in the links
        else {
            rear = rear.prev;

            // If only one element was present
            if (rear == null)
                front = null;
            else
                rear.next = null;

            size--;
        }
    }

    /// Function to return the element at the front end
    int getMin() {
        if (isEmpty())
            return -1;
        return front.data;
    }

    /// Function to return the element at the rear end
    int getMax() {
        if (isEmpty())
            return -1;
        return rear.data;
    }

    /// Function clear the Deque
    void empty() {
        rear = null;
        while (front != null) {
            front = front.next;
        }
        size = 0;
    }
}
