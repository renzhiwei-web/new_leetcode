package stringclass;

import java.util.*;

public class AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod {
    // leetcode 1604 medium 2023/2/7
    // 使用哈希排序
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        int n = keyName.length;
        List<String> ans = new ArrayList<>();
        Map<String,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = keyName[i];
            String time  = keyTime[i];
            map.putIfAbsent(name,new ArrayList<>());
            int hour = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
            int minute = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
            map.get(name).add(hour * 60 + minute);
        }
        for (var name : map.keySet()) {
            List<Integer> list = map.get(name);
            Collections.sort(list);
            int size = list.size();
            for (int i = 2; i < size; i++) {
                int time1 = list.get(i - 2),time2 = list.get(i);
                int diff = time2 - time1;
                if (diff <= 60) {
                    ans.add(name);
                    break;
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
