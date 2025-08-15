import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ArrayFlatternerTest {
    private ArrayFlatterner arrayFlatterner;

    @BeforeEach
    void setUp() {
        arrayFlatterner = new ArrayFlatterner();
    }

    @AfterEach
    void tearDown() {
        arrayFlatterner = null;
    }

    @Test
    void testFlattenArray_EmptyInput() {
        int[][] input = new int[0][0];
        int[] expected = new int[] {};
        int[] result = arrayFlatterner.flattenArray(input);
        assertArrayEquals(expected,result);
    }
    @Test
    public void testFlattenArray_validInput() {
        int[][] input = { {1, 3}, {0}, {4, 5, 9} };
        int[] expected = {1, 3, 0, 4, 5, 9};
        int[] result = arrayFlatterner.flattenArray(input);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testFlattenArray_nullInput() {
        int[][] input = null;
        int[] result = arrayFlatterner.flattenArray(input);
        assertNull(result);
    }
}