### README for Test

# Deque (Double Ended Queue)

## Overview

The `Deque` class represents a modified double-ended queue, which allows retrieval and deletion of elements from both ends (front and rear). However, it uses only one type of insertion: rear insertion. This implementation uses a doubly linked list to store the elements.

## Idea

The problem guarantees that every item we insert is always greater than the existing maximum.
This information helps us interpret the order of the items as ascending(as per the example).
Through this convention we can associate the demanded functionalities with the features of a deque.

## Approach

When building a deque there are two possible approaches:

- Double Linked Lists
- Circular Array

For my implementation I opted for the Double Linked Lists as they do not need a predefined size,
whereas the circular array approach demands a predefined size.

For the deque implementation I also created a Node component that has two "pointers"(next and prev), and the data.


## Features

- Insert elements at the rear end:
  - This type of insertion aligns with the rule described in `Idea`
- Delete elements from the front end:
  - In the front there will always be the smallest number in the bunch, so this behavior can be associated with `extractMin()`
- Delete elements from the rear end:
    - In the rear there will always be the largest number in the bunch, so this behavior can be associated with `extractMax()`
- Retrieve the front element:
    - In the front there will always be the smallest number in the bunch, so this behavior can be associated with `getMin()`
- Retrieve the rear element:
    - In the rear there will always be the largest number in the bunch, so this behavior can be associated with `getMax()`
- Check if the deque is empty:
  - Helper function that keeps the code clean and readable, while also providing an important functionality for the deque
- Get the number of elements in the deque.
- Clear the deque.

## Usage

### Initialization

To create a new deque:

```java
Deque deque = new Deque();
```

### Inserting Elements

To insert an element at the rear end:

```java
deque.insert(element);
```

### Deleting Elements

To delete an element from the front end:

```java
deque.extractMin();
```

To delete an element from the rear end:

```java
deque.extractMax();
```

### Retrieving Elements

To get the front element:

```java
int frontElement = deque.getMin();
```

To get the rear element:

```java
int rearElement = deque.getMax();
```

### Checking Deque Status

To check if the deque is empty:

```java
boolean isEmpty = deque.isEmpty();
```

To get the number of elements in the deque:

```java
int size = deque.getSize();
```

### Clearing the Deque

To clear the deque:

```java
deque.empty();
```

## Example

```java
public class Main {
    public static void main(String[] args) {
        Deque deque = new Deque();

        deque.insert(10);
        deque.insert(20);
        deque.insert(30);

        System.out.println("Front element: " + deque.getMin()); // Output: 10
        System.out.println("Rear element: " + deque.getMax()); // Output: 30

        deque.extractMin();
        System.out.println("Front element after extractMin: " + deque.getMin()); // Output: 20

        deque.extractMax();
        System.out.println("Rear element after extractMax: " + deque.getMax()); // Output: 20
    }
}
```

This example demonstrates the basic operations of the `Deque` class, including insertion, deletion, and retrieval of elements.