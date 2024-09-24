package bryanze.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author lizelin
 * @date 2024/09/11
 */
public class WY_T3 {
    static class Item {
        String name;
        int sort1;
        int sort2;

        public Item(String name, int sort1, int sort2) {
            this.name = name;
            this.sort1 = sort1;
            this.sort2 = sort2;
        }
    }
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item("ace", 8, 4));
        items.add(new Item("bre", 2, 3));
        items.add(new Item("cat", 5, 2));
        items.add(new Item("dog", 1, 1));
        Scanner sc = new Scanner(System.in);
        String orderBy = sc.next();
//        sc.nextLine();
        String orderType = sc.next();
        Comparator<Item> comparator = null;
        if ("sort1".equals(orderBy)) {
            comparator = Comparator.comparingInt(o->o.sort1);
        } else if ("sort2".equals(orderBy)){
            comparator = Comparator.comparingInt(o->o.sort2);
        }


        if ("desc".equals(orderType)) {
            comparator = comparator.reversed();
        }
        items.sort(comparator);
        for (Item item : items) {
            System.out.println(item.name);
        }

    }
}
