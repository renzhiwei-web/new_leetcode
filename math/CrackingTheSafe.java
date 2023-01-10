package math;

import java.util.HashMap;
import java.util.Map;

public class CrackingTheSafe {
    // leetcode 753 hard 2023/1/10
    // 由题意可得，所有的密码可能为k^n种，所有密码总长度为(k^n*n)，要将所有密码压缩到最小长度，则长度为(k^n + (n - 1))
    // 则由题意可得，此为路径搜索问题
    public String crackSafe(int n, int k) {
        //map存储的是当前图的<结点,边权>，由于从大到小遍历，不需要存储所有的边，只需要更改边权即可
        Map<String,Integer> map = new HashMap<>();
        // 路径数量，结点数量
        int kn = (int) Math.pow(k,n);
        StringBuffer ans = new StringBuffer();
        // 初始结点为0000...
        for (int i = 1; i < n; i++) {
            ans.append('0');
        }
        // 若n == 1,则将k的序列遍历一遍即可
        if (ans.length() == 0){
            for (int i = 0; i < k; i++) {
                ans.append(i);
            }
            return ans.toString();
        }
        // 遍历所有的路
        while(kn != 0){
            // 每个密码共享的位数为n-1位，所以取出当前ans的前n-1位字符sub
            String substring = ans.substring(ans.length() - n + 1,ans.length());
            // 查看sub结点是否已经被遍历，若没有遍历，则从边权最大的边开始遍历
            if (!map.containsKey(substring)){
                map.put(substring,k-1);
            }
            ans.append(map.get(substring));
            // 更新sub结点的边权，以便下次遍历
            map.put(substring,map.get(substring) - 1);
            kn--;
        }
        return ans.toString();
    }
}
