package mocking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayReversor {
    private final ArrayFlattenerService flattenerService;

    public ArrayReversor(ArrayFlattenerService flattenerService) {
        this.flattenerService = flattenerService;
    }

    public int[] reverseArray(int[][] arrayInput) {
        int[] flattendedArray = flattenerService.flattenArray(arrayInput);

        if(flattendedArray == null) {
            return null;
        }
        List<Integer> flattenedArrayList = new ArrayList<Integer>();
        for(int[] outer : arrayInput) {
            for(int inner : outer) {
                flattenedArrayList.add(inner);
            }
        }
        Collections.reverse(flattenedArrayList);
        return flattenedArrayList.stream().mapToInt(i -> i).toArray();
    }
}
