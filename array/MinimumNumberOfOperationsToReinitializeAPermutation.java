package array;

import java.util.Arrays;

public class MinimumNumberOfOperationsToReinitializeAPermutation {
    // leetcode 1806 medium 2023/1/9
    // 首先想到暴力方法
    public int reinitializePermutation(int n) {
        int[] prem = new int[n];
        int[] target = new int[n];
        for (int i = 0; i < n; i++) {
            prem[i] = i;
            target[i] = i;
        }
        int ans = 0;
        while(true){
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                if ((i & 1) != 0){
                    arr[i] = prem[n / 2 + (i - 1) / 2];
                }else {
                    arr[i] = prem[i / 2];
                }
            }
            prem = arr;
            ans++;
            if (Arrays.equals(prem,target)){
                break;
            }
        }
        return ans;
    }

    // 观察可得，数组中存在置换环，找到所有置换环的最小公倍数即是最小操作数
    // 最大环的长度即是所有置换环的最小公倍数
    public int reinitializePermutation1(int n) {
        int cnt = 0,ans = 1;
        // 首尾数字一直不变，单独各为一个置换环
        boolean[] vis = new boolean[n];
        for (int i = 1; i < n - 1; i++) {
            int j = i;
            while(!vis[j]){
                vis[j] = true;
                cnt++;
                j = (j & 1) != 0 ? (n / 2 + (j - 1) / 2) : (j / 2);
            }
            ans = Math.max(ans,cnt);
            cnt = 0;
        }
        return ans;
    }
}
