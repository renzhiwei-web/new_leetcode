package stringclass;

import java.util.HashMap;
import java.util.Map;

public class DecodeTheMessage {
    // leetcode 2325 simple 2023/2/1
    // 简单模拟
    public String decodeMessage(String key, String message) {
        Map<Character,Character> map = new HashMap<>();
        char cur = 'a';
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if (ch != ' '){
                if (!map.containsKey(ch)){
                    map.put(ch,cur);
                    cur++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (ch != ' '){
                sb.append(map.get(ch));
            }else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
