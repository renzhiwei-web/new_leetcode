package designClass;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationManager {
    // leetcode 1797 medium 2023/2/9
    // 简单使用哈希模拟即可
    int timeTolive;
    Map<String,Integer> map;
    public AuthenticationManager(int timeToLive) {
        this.timeTolive = timeToLive;
        map = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        map.putIfAbsent(tokenId,currentTime + timeTolive);
    }

    public void renew(String tokenId, int currentTime) {
        if (map.containsKey(tokenId) && map.get(tokenId) > currentTime){
            map.put(tokenId,currentTime + timeTolive);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int ans = 0;
        for (var item : map.keySet()) {
            if (map.get(item) > currentTime){
                ans++;
            }
        }
        return ans;
    }
}
