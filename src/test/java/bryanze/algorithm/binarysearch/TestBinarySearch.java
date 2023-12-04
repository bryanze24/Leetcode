package bryanze.algorithm.binarysearch;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static bryanze.algorithm.binarysearch.BinarySearch.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestBinarySearch {

    @Test
    @DisplayName("测试 binarySearchBasic")
    public void test1() {
        int[] a = {7, 13, 21, 30, 38, 44, 52, 53};
        assertEquals(0, binarySearchBasic(a, 7));
        assertEquals(1, binarySearchBasic(a, 13));
        assertEquals(2, binarySearchBasic(a, 21));
        assertEquals(3, binarySearchBasic(a, 30));
        assertEquals(4, binarySearchBasic(a, 38));
        assertEquals(5, binarySearchBasic(a, 44));
        assertEquals(6, binarySearchBasic(a, 52));
        assertEquals(7, binarySearchBasic(a, 53));

        assertEquals(-1, binarySearchBasic(a, 0));
        assertEquals(-1, binarySearchBasic(a, 15));
        assertEquals(-1, binarySearchBasic(a, 60));
    }

    @Test
    @DisplayName("测试 binarySearchAlternative ")
    public void test2() {
        int[] a = {7, 13, 21, 30, 38, 44, 52, 53};
        assertEquals(0, binarySearchAlternative(a, 7));
        assertEquals(1, binarySearchAlternative(a, 13));
        assertEquals(2, binarySearchAlternative(a, 21));
        assertEquals(3, binarySearchAlternative(a, 30));
        assertEquals(4, binarySearchAlternative(a, 38));
        assertEquals(5, binarySearchAlternative(a, 44));
        assertEquals(6, binarySearchAlternative(a, 52));
        assertEquals(7, binarySearchAlternative(a, 53));

        assertEquals(-1, binarySearchAlternative(a, 0));
        assertEquals(-1, binarySearchAlternative(a, 15));
        assertEquals(-1, binarySearchAlternative(a, 60));
    }

    @Test
    @DisplayName("测试 binarySearchLeftmost 返回 -1")
    public void test3() {
        int[] a = {1, 2, 4, 4, 4, 5, 6, 7};
        assertEquals(0, binarySearchLeftmost1(a, 1));
        assertEquals(1, binarySearchLeftmost1(a, 2));
        assertEquals(2, binarySearchLeftmost1(a, 4));
        assertEquals(5, binarySearchLeftmost1(a, 5));
        assertEquals(6, binarySearchLeftmost1(a, 6));
        assertEquals(7, binarySearchLeftmost1(a, 7));

        assertEquals(-1, binarySearchLeftmost1(a, 0));
        assertEquals(-1, binarySearchLeftmost1(a, 3));
        assertEquals(-1, binarySearchLeftmost1(a, 8));
    }

    @Test
    @DisplayName("测试 binarySearchRightmost 返回 -1")
    public void test4() {
        int[] a = {1, 2, 4, 4, 4, 5, 6, 7};
        assertEquals(0, binarySearchRightmost1(a, 1));
        assertEquals(1, binarySearchRightmost1(a, 2));
        assertEquals(4, binarySearchRightmost1(a, 4));
        assertEquals(5, binarySearchRightmost1(a, 5));
        assertEquals(6, binarySearchRightmost1(a, 6));
        assertEquals(7, binarySearchRightmost1(a, 7));

        assertEquals(-1, binarySearchRightmost1(a, 0));
        assertEquals(-1, binarySearchRightmost1(a, 3));
        assertEquals(-1, binarySearchRightmost1(a, 8));
    }

    @Test
    @DisplayName("测试 binarySearchLeftmost 返回 i")
    public void test5() {
        int[] a = {1, 2, 4, 4, 4, 7, 8};
        assertEquals(0, binarySearchLeftmost2(a, 1));
        assertEquals(1, binarySearchLeftmost2(a, 2));
        assertEquals(2, binarySearchLeftmost2(a, 4));
        assertEquals(5, binarySearchLeftmost2(a, 7));
        assertEquals(6, binarySearchLeftmost2(a, 8));

        assertEquals(0, binarySearchLeftmost2(a, 0));
        assertEquals(2, binarySearchLeftmost2(a, 3));
        assertEquals(5, binarySearchLeftmost2(a, 5));
        assertEquals(7, binarySearchLeftmost2(a, 9));
    }

    @Test
    @DisplayName("测试 binarySearchRightmost 返回 i-1")
    public void test6() {
        int[] a = {1, 2, 4, 4, 4, 5, 6, 7};
        assertEquals(0, binarySearchRightmost2(a, 1));
        assertEquals(1, binarySearchRightmost2(a, 2));
        assertEquals(4, binarySearchRightmost2(a, 4));
        assertEquals(5, binarySearchRightmost2(a, 5));
        assertEquals(6, binarySearchRightmost2(a, 6));
        assertEquals(7, binarySearchRightmost2(a, 7));

        assertEquals(0, binarySearchRightmost2(a, 0) + 1);
        assertEquals(2, binarySearchRightmost2(a, 3) + 1);
        assertEquals(8, binarySearchRightmost2(a, 8) + 1);
    }
}
