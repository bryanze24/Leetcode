package bryanze.datastructure.array;


import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

//动态数组
public class DynamicArray implements Iterable<Integer> {

    //逻辑大小
    private int size = 0;
    //容量
    private int capacity = 8;

    private int[] array = {};

    //添加元素
    public void addLast(int element){
//        array[size] = element;
//        size++;
        add(size, element);
    }

    //插入元素
    public void add(int index, int element){

        //检查容量
        checkAndGrow();

        //添加的逻辑
        if (index >= 0 && index < size) {
            System.arraycopy(array,index,array,index + 1,size - index);
        }

        array[index] = element;
        size++;
    }

    //扩容的方法
    private void checkAndGrow(){

        if(size == 0){
            array = new int[capacity];
        }

        if(size == capacity){
            //进行扩容
            capacity += capacity >> 1;
            int[] newArray = new int[capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    //查询元素
    public int get(int index){
        return array[index];
    }

    //遍历
    public void traverse(Consumer<Integer> consumer){
        for (int i = 0; i < size; i++) {
            consumer.accept(array[i]);
        }
    }


    //迭代器便遍历
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            int i = 0;

            @Override
            public boolean hasNext() { // 有没有下一个元素
                return i < size;
            }

            @Override
            public Integer next() { //返回当前元素,并且移动到下一个元素
                return array[i++];
            }
        };
    }

    //使用stream流遍历
    public IntStream stream(){
        return  IntStream.of(Arrays.copyOfRange(array,0,size));
    }


    public int remove(int index){
        int removed = array[index];

        if(index < size - 1){
            System.arraycopy(array,index + 1, array, index, size - index - 1);
        }

        size--;
        return removed;
    }
}
