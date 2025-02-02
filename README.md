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

# Duplicates

## Overview

The `Duplicates` class provides a method to check if an array of integers contains any duplicate elements.
It uses the merge sort algorithm to sort the array and then checks for duplicates by comparing adjacent elements.

## Idea
In order to avoid using any features that would require Collections,
I opted for a simple approach that would sort the array and then check for duplicates.
For the sorting algorithm I had multiple options such as a simple double for loop, Bubble Sort, Quick Sort, Merge Sort, etc.
I chose Merge Sort as it is a stable sorting algorithm with a time complexity of O(n log n).
After sorting the array, I simply checked for duplicates by comparing adjacent elements.

## Features

- **Check for Duplicates**: The main functionality of the `Duplicates` class is to determine if an array contains any duplicate elements.

## Usage

### Initialization

The `Duplicates` class does not require instantiation as it provides a static method.

### Checking for Duplicates

To check if an array contains duplicates, use the `hasDuplicates` method:

```java
int[] array = {1, 2, 3, 4, 5};
boolean result = Duplicates.hasDuplicates(array);
System.out.println("Contains duplicates: " + result); // Output: Contains duplicates: false
```

### Method Details

#### `hasDuplicates`

```java
public static boolean hasDuplicates(int[] arr)
```

- **Parameters**:
  - `arr`: An array of integers to be checked for duplicates.
- **Returns**:
  - `true` if the array contains duplicate elements, `false` otherwise.
- **Description**:
  - This method first checks if the array is null or has fewer than two elements, in which case it returns `false` as there can't be any duplicates.
  - It then sorts the array using the `MergeSort` class and checks for duplicates by comparing adjacent elements.

## Example

```java
public class Main {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {1, 2, 3, 3, 4, 5};

        System.out.println("Array1 contains duplicates: " + Duplicates.hasDuplicates(array1)); // Output: false
        System.out.println("Array2 contains duplicates: " + Duplicates.hasDuplicates(array2)); // Output: true
    }
}
```

This example demonstrates how to use the `Duplicates` class to check if arrays contain duplicate elements.

