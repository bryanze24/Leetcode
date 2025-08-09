package bryanze.leetcode;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DDZ {
    // 牌的类型和数量
    private static final String[] CARD_TYPES = {
            "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"
    };
    private static final String[] CARD_COLORS = {
            "♠", "♥", "♦", "♣"
    };
    private static final String[] JOKERS = {
            "小王", "大王"
    };

    // 牌的赋分
    private static int calculateHandScore(List<String> hand) {
        int score = 0;
        for (String card : hand) {
            if (card.contains("王")) {
                score += 5;  // 大小王分值高
            } else if (card.startsWith("2")) {
                score += 4;  // 2分值较高
            } else if (card.startsWith("A")) {
                score += 3;
            } else if (card.startsWith("K") || card.startsWith("Q") || card.startsWith("J")) {
                score += 2;
            } else {
                score += 1;  // 其他牌分值低
            }
        }
        return score;
    }

    // 创建一副牌
    private static List<String> createDeck() {
        List<String> deck = new ArrayList<>();

        // 添加普通牌
        for (String color : CARD_COLORS) {
            for (String type : CARD_TYPES) {
                deck.add(color + type);
            }
        }

        // 添加大小王
        deck.add(JOKERS[0]);
        deck.add(JOKERS[1]);

        return deck;
    }

    // 洗牌
    private static void shuffleDeck(List<String> deck) {
        Collections.shuffle(deck);
    }

    // 模拟斗地主
    private static boolean simulateGame() {
        // 创建并洗牌
        List<String> deck = createDeck();
        shuffleDeck(deck);

        // 三个玩家
        List<List<String>> players = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            players.add(new ArrayList<>());
        }
        int size = players.size();

        final ReentrantLock lock = new ReentrantLock();
        final Condition[] conditions = new Condition[size];


        for (int i = 0; i < size; i++) {
            conditions[i] = lock.newCondition();
        }


        // 记录当前应该抓牌的玩家
        AtomicInteger currentPlayer = new AtomicInteger(0);

        // 多线程模拟抓牌
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<?>> futures = new ArrayList<>();

        //轮流抓牌
        for (int i = 0; i < 3; i++) {
            final int playerIndex = i;
            futures.add(executor.submit(() -> {
                for (int j = 0; j < 17; j++) {
                    lock.lock();
                    try {
                        while (currentPlayer.get() != playerIndex) {
                            conditions[playerIndex].await();
                        }

                        if (!deck.isEmpty()) {
                            //System.out.println("玩家" + playerIndex + "抓牌");
                            players.get(playerIndex).add(deck.remove(0));
                        }

                        // 切换到下一个玩家
                        currentPlayer.set((playerIndex + 1) % size);
                        conditions[currentPlayer.get()].signal();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }

                }
            }));
        }
        // 等待所有玩家抓完牌
        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();

        // 随机选择地主
        int landlordIndex = new Random().nextInt(3);
        List<String> landlordHand = players.get(landlordIndex);

        // 地主拿剩下的3张牌
        for (int i = 0; i < 3 && !deck.isEmpty(); i++) {
            landlordHand.add(deck.remove(0));
        }

        // 计算地主和农民的手牌得分
        int landlordScore = calculateHandScore(landlordHand);
        int farmerScore = 0;
        for (int i = 0; i < 3; i++) {
            if (i != landlordIndex) {
                farmerScore += calculateHandScore(players.get(i));
            }
        }

        // 规则：地主得分高于农民总得分的60%则视为地主胜利
        return landlordScore > farmerScore * 0.6;
    }

    public static void main(String[] args) {
        int totalGames = 10000;  // 模拟游戏次数
        int landlordWins = 0;

        System.out.println("开始模拟" + totalGames + "局游戏...");


        for (int i = 0; i < totalGames; i++) {
            if (simulateGame()) {
                landlordWins++;
            }
        }


        double winRate = (double) landlordWins / totalGames * 100;
        System.out.println("地主胜利次数: " + landlordWins);
        System.out.println("地主胜利概率: " + String.format("%.2f", winRate) + "%");
    }
}
