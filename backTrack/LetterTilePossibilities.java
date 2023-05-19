package backTrack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LetterTilePossibilities {
    // leetcod 1079 2023/5/19 medium
    // 由题意容易得，使用回溯方法进行解题
    public int numTilePossibilities(String tiles) {
        Map<Character,Integer> count = new HashMap<>();
        for (char t : tiles.toCharArray()) {
            count.put(t,count.getOrDefault(t,0) + 1);
        }
        Set<Character> tile = new HashSet<>(count.keySet());
        // 非空字符串需要-1
        return dfs(tiles.length(),count,tile) - 1;
    }

    private int dfs(int i, Map<Character, Integer> count, Set<Character> tile) {
        if (i == 0){
            return 1;
        }
        int ans = 1;
        for (char t : tile) {
            if (count.get(t) > 0) {
                count.put(t,count.get(t) - 1);
                ans += dfs(i - 1,count,tile);
                count.put(t,count.get(t) + 1);
            }
        }
        return ans;
    }
}
