package stringclass;

import java.util.HashMap;
import java.util.Map;

public class BestPokerHand {
    // leetcode 2347 simple 2023/2/20
    // 简单模拟即可
    public String bestHand(int[] ranks, char[] suits) {
        int len = ranks.length;
        Map<Integer,Integer> ranksMap = new HashMap<>();
        Map<Character,Integer> sutisMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            ranksMap.put(ranks[i],ranksMap.getOrDefault(ranks[i],0) + 1);
            sutisMap.put(suits[i],sutisMap.getOrDefault(suits[i],0) + 1);
        }
        if (sutisMap.size() == 1){
            return "Flush";
        } else if (ranksMap.size() == 5) {
            return "High Card";
        }else {
            for (var key : ranksMap.keySet()) {
                if (ranksMap.get(key) >= 3){
                    return "Three of a Kind";
                }
            }
            return "Pair";
        }
    }
}
