package array;

import java.util.HashMap;
import java.util.Map;

public class FindLongestSubarrayLcci {
    // 由题意可得，可以将问题转换成以下问题
    // 字母为1，数字为-1，求数组中和为0的最长子数组
    // 由此可以容易想出，使用前缀和进行解题
    // 通过判断前后索引前缀和是否相同(包括0),可得出此段数组和为0
    public String[] findLongestSubarray(String[] array) {
        int len = array.length;
        Map<Integer,Integer> indices = new HashMap<>();
        indices.put(0,-1);
        int sum = 0;
        int maxLength = 0;
        int startIndex = -1;
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(array[i].charAt(0))){
                sum--;
            }else {
                sum++;
            }
            if (indices.containsKey(sum)){
                int firstIndex = indices.get(sum);
                if (i - firstIndex > maxLength) {
                    maxLength = i - firstIndex;
                    startIndex = firstIndex + 1;
                }
            }else {
                indices.put(sum,i);
            }
        }
        if (maxLength == 0){
            return new String[0];
        }
        String[] ans = new String[maxLength];
        System.arraycopy(array,startIndex,ans,0,maxLength);
        return ans;
    }
}
