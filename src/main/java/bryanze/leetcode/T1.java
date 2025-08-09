package bryanze.leetcode;

/**
 * @author lizelin
 * @date 2024/10/12
 */
import java.util.*;

public class T1 {
    // 并查集类
    static class UnionFind {
        private Map<String, String> parent = new HashMap<>();

        // 查找根节点，路径压缩
        public String find(String x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
            }
            if (!x.equals(parent.get(x))) {
                parent.put(x, find(parent.get(x)));
            }
            return parent.get(x);
        }

        // 合并两个节点
        public void union(String x, String y) {
            String rootX = find(x);
            String rootY = find(y);
            if (!rootX.equals(rootY)) {
                parent.put(rootX, rootY);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        UnionFind uf = new UnionFind();
        Map<String, String> phoneToName = new HashMap<>();  // 记录手机号对应的姓名
        Map<String, Set<String>> nameToPhones = new HashMap<>();  // 记录合并后的姓名及其所有手机号集合

        // 处理每一条联系人记录
        for (int i = 0; i < num; i++) {
            String[] record = scanner.nextLine().split(" ");
            String name = record[0];
            String firstPhone = record[1];

            // 将该联系人的所有手机号与第一个手机号进行合并
            for (int j = 1; j < record.length; j++) {
                String phone = record[j];
                uf.union(firstPhone, phone);
                phoneToName.put(phone, name);  // 记录每个手机号对应的姓名
            }
        }

        // 将每个手机号归类到所属联系人中
        for (String phone : phoneToName.keySet()) {
            String rootPhone = uf.find(phone);
            String name = phoneToName.get(phone);

            // 将同一联系人的手机号归并到一组
            nameToPhones.putIfAbsent(rootPhone, new TreeSet<>());
            nameToPhones.get(rootPhone).add(phone);
        }

        // 将结果输出，按照姓名和手机号码字典序排序
        List<Map.Entry<String, Set<String>>> entries = new ArrayList<>(nameToPhones.entrySet());
        entries.sort((e1, e2) -> {
            String name1 = phoneToName.get(e1.getKey());
            String name2 = phoneToName.get(e2.getKey());
            if (!name1.equals(name2)) {
                return name1.compareTo(name2);
            } else {
                return comparePhoneLists(new ArrayList<>(e1.getValue()), new ArrayList<>(e2.getValue()));
            }
        });

        // 输出结果
        for (Map.Entry<String, Set<String>> entry : entries) {
            String name = phoneToName.get(entry.getKey());
            System.out.print(name);
            for (String phone : entry.getValue()) {
                System.out.print(" " + phone);
            }
            System.out.println();
        }
    }

    // 比较两个手机号列表
    private static int comparePhoneLists(List<String> list1, List<String> list2) {
        int len = Math.min(list1.size(), list2.size());
        for (int i = 0; i < len; i++) {
            int cmp = list1.get(i).compareTo(list2.get(i));
            if (cmp != 0) {
                return cmp;
            }
        }
        return Integer.compare(list1.size(), list2.size());
    }
}

