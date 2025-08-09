package bryanze.leetcode;

/**
 * @author lizelin
 * @date 2024/10/12
 */
import java.util.*;


public class T3 {

    static class FolderNode {
        String name;
        Map<String, FolderNode> children = new HashMap<>();
        boolean isDuplicate = false;

        FolderNode(String name) {
            this.name = name;
        }
    }

    public static List<String> findDuplicateFolders(String[] paths) {
        FolderNode root = new FolderNode(""); // 虚拟根节点
        Map<String, Integer> structureMap = new HashMap<>(); // 文件夹结构 -> 出现次数
        List<String> result = new ArrayList<>(); // 存储结果的列表

        // 构建文件夹树
        for (String path : paths) {
            String[] folders = path.split("/");
            FolderNode current = root;
            for (int i = 1; i < folders.length; i++) { // 从1开始忽略空字符串
                current.children.putIfAbsent(folders[i], new FolderNode(folders[i]));
                current = current.children.get(folders[i]);
            }
        }

        // 递归生成文件夹结构，并检测重复文件夹
        detectDuplicates(root, structureMap);

        // 收集所有重复的文件夹路径
        collectDuplicates(root, "", result);

        // 如果结果为空，返回 "NotFound"
        if (result.isEmpty()) {
            result.add("NotFound");
        } else {
            Collections.sort(result); // 按字典序排序
        }

        return result;
    }

    // 递归生成文件夹结构的唯一表示，并记录到哈希表中
    private static String detectDuplicates(FolderNode node, Map<String, Integer> structureMap) {
        if (node.children.isEmpty()) {
            return ""; // 空文件夹不需要结构表示
        }

        // 生成当前文件夹的子结构
        List<String> childStructures = new ArrayList<>();
        for (FolderNode child : node.children.values()) {
            childStructures.add(child.name + detectDuplicates(child, structureMap));
        }

        // 按字典序排序确保唯一性
        Collections.sort(childStructures);
        String structure = "(" + String.join(",", childStructures) + ")";

        // 更新哈希表，记录当前结构出现的次数
        structureMap.put(structure, structureMap.getOrDefault(structure, 0) + 1);

        // 如果该结构出现超过一次，标记为重复文件夹
        if (structureMap.get(structure) > 1) {
            node.isDuplicate = true;
        }

        return structure;
    }

    // 递归收集重复文件夹的路径，确保父子关系只返回最高层父文件夹
    private static void collectDuplicates(FolderNode node, String path, List<String> result) {
        for (Map.Entry<String, FolderNode> entry : node.children.entrySet()) {
            FolderNode child = entry.getValue();
            String currentPath = path + "/" + child.name;

            // 如果是重复文件夹，且没有被子文件夹覆盖，则收集路径
            if (child.isDuplicate) {
                result.add(currentPath + "/");
            }

            // 递归处理子文件夹
            collectDuplicates(child, currentPath, result);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 读取路径的数量
        scanner.nextLine(); // 读取换行符

        String[] paths = new String[n];
        for (int i = 0; i < n; i++) {
            paths[i] = scanner.nextLine(); // 读取每一行路径
        }

        List<String> result = findDuplicateFolders(paths);
        for (String path : result) {
            System.out.println(path);
        }
    }
}


