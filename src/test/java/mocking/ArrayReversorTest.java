package mocking;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ArrayReversorTest {
    private ArrayFlattenerService arrayFlattenerService;
    private ArrayReversor arrayReversor;

    @BeforeEach
    void setUp() {
        arrayFlattenerService = Mockito.mock(ArrayFlattenerService.class);
        arrayReversor = new ArrayReversor(arrayFlattenerService);
    }

    @AfterEach
    void tearDown() {
        arrayFlattenerService = null;
        arrayReversor = null;
    }

    @Test
    public void testReverseArray_emptyInput() {
        int[][] input = new int[0][0];
        int[] flattened = new int[] {};

        when(arrayFlattenerService.flattenArray(input)).thenReturn(flattened);

        int[] expected = new int[] {};
        int[] result = arrayReversor.reverseArray(input);

        assertArrayEquals(expected, result);
        verify(arrayFlattenerService, times(1)).flattenArray(input);
    }
    @Test
    public void testReverseArray_validInput() {
        int[][] input = { {1, 3}, {0}, {4, 5, 9} };
        int[] flattened = {1, 3, 0, 4, 5, 9};

        when(arrayFlattenerService.flattenArray(input)).thenReturn(flattened);

        int[] expected = {9, 5, 4, 0, 3, 1};
        int[] result = arrayReversor.reverseArray(input);

        assertArrayEquals(expected, result);
        verify(arrayFlattenerService, times(1)).flattenArray(input);
    }

    @Test
    public void testReverseArray_nullInput() {
        when(arrayFlattenerService.flattenArray(null)).thenReturn(null);

        int[] result = arrayReversor.reverseArray(null);

        assertNull(result);
        verify(arrayFlattenerService, times(1)).flattenArray(null);
    }
}