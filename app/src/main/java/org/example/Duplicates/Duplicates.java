package org.example.Duplicates;

public class Duplicates {
    public static boolean hasDuplicates(int[] arr) {
        if (arr == null || arr.length < 2) {
            return false;
        }

        MergeSort ob = new MergeSort();
        ob.sort(arr);

        // Check adjacent elements for duplicates
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return true;
            }
        }

        return false;
    }
}
