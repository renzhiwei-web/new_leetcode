package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class RemoveLetterToEqualizeFrequency {
    // leetcode 2433 计数+哈希算法
    public boolean equalFrequency(String word) {
        var mCnt = new HashMap<Character, Integer>();
        for (var c : word.toCharArray()){
            // 新写法，相当于将此key的以前value+1
            mCnt.merge(c, 1, Integer::sum);
        }
        var cnt = new ArrayList<>(mCnt.values());
        Collections.sort(cnt); // 出现次数从小到大排序
        int m = cnt.size();
        // 只有一种字符 or 去掉次数最少的 or 去掉次数最多的
        return m == 1 ||
                cnt.get(0) == 1 && isSame(cnt.subList(1, m)) ||
                cnt.get(m - 1) == cnt.get(m - 2) + 1 && isSame(cnt.subList(0, m - 1));
    }

    private boolean isSame(List<Integer> cnt) {
        int c0 = cnt.get(0);
        for (int c : cnt)
            if (c != c0)
                return false;
        return true;
    }
}
