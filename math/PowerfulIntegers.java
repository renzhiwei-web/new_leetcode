package math;

import java.util.*;

public class PowerfulIntegers {
    // leetcode 970 2023/5/2
    // 简单模拟即可，但是要小心x,y等于1时的情况
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> ans = new HashSet<>();
        for (int a = 1; a <= bound; a *= x) {
            for (int b = 1; a + b <= bound; b *= y) {
                ans.add(a + b);
                if (y == 1) {
                    break;
                }
            }
            if (x == 1) {
                break;
            }
        }
        return new ArrayList<>(ans);
    }
}
