package bryanze.datastructure.array;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;


public class TestDynamicArray {

    @Test
    public void test1(){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);
//        dynamicArray.addLast(6);
        dynamicArray.add(2,6);
        for (int i = 0; i < 6; i++) {
            System.out.println(dynamicArray.get(i));
        }
    }

    @Test
    public void test2(){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);

        dynamicArray.traverse((element) ->{
            System.out.println(element);
        });
    }

    @Test
    public void test3(){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);

        for (Integer element : dynamicArray) {
            System.out.println(element);
        }
    }

    @Test
    public void test4(){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);

        dynamicArray.stream().forEach(element ->{
            System.out.println(element);
        });
    }

    @Test
    @DisplayName("测试删除")
    public void test5(){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);

        int removed = dynamicArray.remove(2);

        assertEquals(3,removed);

        dynamicArray.stream().forEach(element ->{
            System.out.println(element);
        });
    }

    @Test
    @DisplayName("测试扩容")
    public void test6(){
        DynamicArray dynamicArray = new DynamicArray();
        for (int i = 0; i < 9; i++) {
            dynamicArray.addLast(i + 1);
        }
        assertIterableEquals(
                Arrays.asList(1,2,3,4,5,6,7,8,9),
                dynamicArray
        );
    }
}
