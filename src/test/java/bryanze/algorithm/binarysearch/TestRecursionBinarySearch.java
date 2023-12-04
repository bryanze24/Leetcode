package bryanze.algorithm.binarysearch;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static bryanze.algorithm.binarysearch.RecursionBinarySearch.search;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRecursionBinarySearch {

    @Test
    @DisplayName("测试RecursionBinarySearch")
    public void test1(){
        int[] a = {7, 13, 21, 30, 38, 44, 52, 53};
        assertEquals(0,search(a,7));
        assertEquals(1,search(a,13));
        assertEquals(2,search(a,21));
        assertEquals(5,search(a,44));


        assertEquals(-1,search(a,77));
        assertEquals(-1,search(a,54));
        assertEquals(-1,search(a,26));
    }
}
