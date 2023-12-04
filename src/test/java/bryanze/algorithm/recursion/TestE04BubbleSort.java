package bryanze.algorithm.recursion;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestE04BubbleSort {

    @Test
    @DisplayName("测试冒泡排序")
    public void test(){
        int[] expect = {1, 2, 3, 4, 5};

        int[] a1 = {5, 4, 3, 2, 1};
        E04BubbleSort.sort(a1);
        assertArrayEquals(expect, a1);

        int[] a2 = {3, 5, 4, 2, 1};
        E04BubbleSort.sort(a2);
        assertArrayEquals(expect, a2);

        int[] a3 = {3, 1, 5, 2, 4};
        E04BubbleSort.sort(a3);
        assertArrayEquals(expect, a3);

        int[] a4 = {1, 2, 3, 4, 5};
        E04BubbleSort.sort(a4);
        assertArrayEquals(expect, a4);
    }
}
