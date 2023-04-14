package stringclass;

import java.util.ArrayList;
import java.util.List;

public class CamelcaseMatching {
    // leetcode 1023 medium 2023/4/13
    // 双指针进行遍历
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        for (String query : queries) {
            boolean flag = true;
            int p = 0;
            for (int j = 0; j < query.length(); j++) {
                char c = query.charAt(j);
                if (p < pattern.length() && pattern.charAt(p) == c) {
                    p++;
                } else if (Character.isUpperCase(c)) {
                    flag = false;
                    break;
                }
            }
            if (p < pattern.length()) {
                flag = false;
            }
            ans.add(flag);
        }
        return ans;
    }
}
