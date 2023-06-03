package stringclass;

import java.util.HashMap;
import java.util.Map;

public class SwapForLongestRepeatedCharacterSubstring {
    public int maxRepOpt1(String text) {
        int len = text.length();
        char[] chs = text.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (char ch : chs) {
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }
        int left = 0;
        int ans = 0;
        while (left < len){
            int right = left;
            // 找到一段连续的子串
            while (right < len && chs[left] == chs[right]){
                right++;
            }
            int curCnt = right - left;
            // 如果这一段长度小于该字符出现的总数，并且前面或后面有空位，则使用 curCnt + 1 更新答案
            if (curCnt < map.getOrDefault(chs[left],0) && (right < len || left > 0)) {
                ans = Math.max(ans,curCnt + 1);
            }
            int k = right + 1;
            // 找到这一段后面与之相隔一个不同字符的另一段 [j + 1, k)，如果不存在则 k = j + 1
            while (k < len && chs[k] == chs[left]){
                k++;
            }
            ans = Math.max(ans,Math.min(k - left,map.getOrDefault(chs[left],0)));
            left = right;
        }
        return ans;
    }
}
