import java.util.ArrayList;
import java.util.List;

public class ArrayFlatterner {
    public int[] flattenArray(int[][] arr) {
        List<Integer> flattendArr = new ArrayList<>();
        for(int[] outerArr : arr) {
            for(int innerArr : outerArr) {
                flattendArr.add(innerArr);
            }
        }
        return flattendArr.stream().mapToInt(i -> i).toArray();
    }
}
