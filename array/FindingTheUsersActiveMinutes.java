package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindingTheUsersActiveMinutes {
    // leetcode 1817 medium 2023/1/20
    // 简单模拟
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] ans = new int[k];
        Map<Integer, Set> map = new HashMap<>();
        for (int[] log : logs) {
            Set<Integer> set = map.getOrDefault(log[0],new HashSet());
            set.add(log[1]);
            map.put(log[0], set);
        }
        for (Map.Entry<Integer,Set> entry:map.entrySet()){
            ans[entry.getValue().size() - 1]++;
        }
        return ans;
    }
}
