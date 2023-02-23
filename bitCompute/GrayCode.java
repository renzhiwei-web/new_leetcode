package bitCompute;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    // leetcode 87 medium 2023/2/22
    // 首先，根据规律可得，先得到n-1个排列Gn-1，将Gn-1复制并翻转，再将其中的n-1位二进制位从0变成1
    // 即可得到另一半排列
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        for (int i = 1; i <= n; i++) {
            int m = ans.size();
            for (int j = m - 1; j >= 0; j--) {
                ans.add(ans.get(j) | (1 << (i - 1)));
            }
        }
        return ans;
    }

    // 公式法
    public List<Integer> grayCode1(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            ans.add((i >> 1) ^ i);
        }
        return ans;
    }
}
