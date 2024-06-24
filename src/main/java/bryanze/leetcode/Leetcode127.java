package bryanze.leetcode;

import java.util.*;

/**
 * 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列
 * beginWord -> s1 -> s2 -> ... -> sk：
 * 每一对相邻的单词只差一个字母。
 * 对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。
 * sk == endWord
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的
 * 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0 。
 *
 * @author lizelin
 * @date 2024/05/13
 */
public class Leetcode127 {

    //单向bfs
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        HashSet<String> wordSet = new HashSet<>(wordList);
        LinkedList<String> queue = new LinkedList<>();
        HashSet<String> visit = new HashSet<>();
        queue.offer(beginWord);
        visit.add(beginWord);

        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                boolean flag = bfs(wordSet, visit, queue, currentWord, endWord);
                if (flag) {
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }

    private boolean bfs(HashSet<String> wordSet, HashSet<String> visit, LinkedList<String> queue,
                        String currentWord, String endWord) {
        char[] array = currentWord.toCharArray();
        for (int i = 0; i < endWord.length(); i++) {
            char c = array[i];
            for (char temp = 'a'; temp <= 'z'; temp++) {
                if (temp == c) {
                    continue;
                }

                array[i] = temp;
                String word = String.valueOf(array);
                if (wordSet.contains(word)) {

                    if (word.equals(endWord)) {
                        return true;
                    }

                    if (!visit.contains(word)) {
                        queue.offer(word);
                        visit.add(word);
                    }
                }
            }
            array[i] = c;
        }
        return false;
    }


    //双向bfs
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        // 第 1 步：先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        // 第 2 步：已经访问过的 word 添加到 visited 哈希表里
        Set<String> visited = new HashSet<>();
        // 分别用左边和右边扩散的哈希表代替单向 BFS 里的队列，它们在双向 BFS 的过程中交替使用
        Set<String> beginVisited = new HashSet<>();
        beginVisited.add(beginWord);
        Set<String> endVisited = new HashSet<>();
        endVisited.add(endWord);

        // 第 3 步：执行双向 BFS，左右交替扩散的步数之和为所求
        int step = 1;
        while (!beginVisited.isEmpty() && !endVisited.isEmpty()) {
            // 优先选择小的哈希表进行扩散，考虑到的情况更少
            if (beginVisited.size() > endVisited.size()) {
                Set<String> temp = beginVisited;
                beginVisited = endVisited;
                endVisited = temp;
            }

            // 逻辑到这里，保证 beginVisited 是相对较小的集合，nextLevelVisited 在扩散完成以后，
            // 会成为新的 beginVisited
            Set<String> nextLevelVisited = new HashSet<>();
            for (String word : beginVisited) {
                if (changeWordEveryOneLetter(word, endVisited, visited, wordSet, nextLevelVisited)) {
                    return step + 1;
                }
            }

            // 原来的 beginVisited 废弃，从 nextLevelVisited 开始新的双向 BFS
            beginVisited = nextLevelVisited;
            step++;
        }
        return 0;
    }


    /**
     * 尝试对 word 修改每一个字符，看看是不是能落在 endVisited 中，
     * 扩展得到的新的 word 添加到 nextLevelVisited 里
     *
     * @param word             需要修改的字符
     * @param endVisited       目标字符
     * @param visited          已访问过的字符串哈希表
     * @param wordSet          单词列表的哈希表
     * @param nextLevelVisited 中间变量
     * @return word是否可以修改一个字符变为目标字符
     */
    private boolean changeWordEveryOneLetter(String word, Set<String> endVisited,
                                             Set<String> visited,
                                             Set<String> wordSet,
                                             Set<String> nextLevelVisited) {
        char[] charArray = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            char originChar = charArray[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (originChar == c) {
                    continue;
                }
                charArray[i] = c;
                String nextWord = String.valueOf(charArray);
                if (wordSet.contains(nextWord)) {
                    if (endVisited.contains(nextWord)) {
                        return true;
                    }
                    if (!visited.contains(nextWord)) {
                        nextLevelVisited.add(nextWord);
                        visited.add(nextWord);
                    }
                }
            }
            // 恢复，下次再用
            charArray[i] = originChar;
        }
        return false;
    }


    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(new Leetcode127().ladderLength(beginWord, endWord, wordList));
    }
}
