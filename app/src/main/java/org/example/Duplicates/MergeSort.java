package org.example.Duplicates;

public class MergeSort {
    /**
     * Sorts the entire array using merge sort algorithm.
     * @param array Array to be sorted
     */
    public void sort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        sortRange(array, 0, array.length - 1);
    }

    /**
     * Recursively sorts a portion of the array.
     * @param array Array to be sorted
     * @param start Starting index of the range
     * @param end Ending index of the range
     */
    private void sortRange(int[] array, int start, int end) {
        if (start < end) {
            int middle = start + (end - start) / 2;

            sortRange(array, start, middle);
            sortRange(array, middle + 1, end);
            merge(array, start, middle, end);
        }
    }

    /**
     * Merges two sorted subarrays into a single sorted array.
     * @param array Array containing both subarrays
     * @param start Start index of first subarray
     * @param middle End index of first subarray
     * @param end End index of second subarray
     */
    private void merge(int[] array, int start, int middle, int end) {
        int leftSize = middle - start + 1;
        int rightSize = end - middle;

        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        // Copy data to temporary arrays
        System.arraycopy(array, start, leftArray, 0, leftSize);
        System.arraycopy(array, middle + 1, rightArray, 0, rightSize);

        int leftIndex = 0;
        int rightIndex = 0;
        int mergedIndex = start;

        // Merge temporary arrays back into original array
        while (leftIndex < leftSize && rightIndex < rightSize) {
            if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                array[mergedIndex] = leftArray[leftIndex++];
            } else {
                array[mergedIndex] = rightArray[rightIndex++];
            }
            mergedIndex++;
        }

        // Copy remaining elements
        while (leftIndex < leftSize) {
            array[mergedIndex++] = leftArray[leftIndex++];
        }
        while (rightIndex < rightSize) {
            array[mergedIndex++] = rightArray[rightIndex++];
        }
    }
}
