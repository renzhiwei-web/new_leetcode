package bitCompute;

import java.util.ArrayList;
import java.util.List;

public class CircularPermutationInBinaryRepresentation {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> ans = new ArrayList<>();
        ans.add(start);
        for (int i = 1; i <= n; i++) {
            int m = ans.size();
            for (int j = m - 1; j >= 0 ; j--) {
                ans.add(((ans.get(j) ^ start) | (1 << (i - 1))) ^ start);
            }
        }
        return ans;
    }

    // 公式法
    public List<Integer> circularPermutation1(int n, int start) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            ans.add((i >> 1) ^ i ^ start);
        }
        return ans;
    }
}
