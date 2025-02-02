package org.example.Duplicates;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DuplicatesTest {

    @Test
    public void hasDuplicates_NullArray_ReturnsFalse() {
        assertFalse(Duplicates.hasDuplicates(null));
    }

    @Test
    public void hasDuplicates_EmptyArray_ReturnsFalse() {
        assertFalse(Duplicates.hasDuplicates(new int[] {}));
    }

    @Test
    public void hasDuplicates_SingleElementArray_ReturnsFalse() {
        assertFalse(Duplicates.hasDuplicates(new int[] {1}));
    }

    @Test
    public void hasDuplicates_NoDuplicates_ReturnsFalse() {
        assertFalse(Duplicates.hasDuplicates(new int[] {1, 2, 3, 4, 5}));
    }

    @Test
    public void hasDuplicates_WithDuplicates_ReturnsTrue() {
        assertTrue(Duplicates.hasDuplicates(new int[] {1, 2, 3, 3, 4, 5}));
    }

    @Test
    public void hasDuplicates_AllElementsSame_ReturnsTrue() {
        assertTrue(Duplicates.hasDuplicates(new int[] {1, 1, 1, 1, 1}));
    }
}