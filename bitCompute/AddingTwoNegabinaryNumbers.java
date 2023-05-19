package bitCompute;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class AddingTwoNegabinaryNumbers {
    // leetcode 1073 首先将负二进制数转成十进制数相加，然后再将十进制数转成负2进制
    // 此方法比较耗时
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int a = arrToInt(arr1),b = arrToInt(arr2);
        int c = a + b;
        return intToArr(c);
    }

    private int[] intToArr(int c) {
        Stack<Integer> stack = new Stack<>();
        while (c != 0){
            stack.push(c % (-2));
            c /= -2;
        }
        int[] ans = new int[stack.size()];
        int i = 0;
        while (!stack.empty()){
            ans[i] = stack.pop();
            i++;
        }
        return ans;
    }

    private int arrToInt(int[] arr) {
        int len = arr.length;
        int ans = 0;
        for (int i = len - 1,j = 0; i >= 0 ; i--,j++) {
            if (arr[i] == 1) {
                ans += (int) Math.pow(-2, j);
            }
        }
        return ans;
    }
    //

    public int[] addNegabinary1(int[] arr1, int[] arr2) {
        int i = arr1.length - 1,j = arr2.length - 1;
        List<Integer> ans = new ArrayList<>();
        // c 为进位数
        for (int c = 0; i >= 0 || j >= 0 || c != 0;i--,j--) {
            int a = i < 0 ? 0 : arr1[i];
            int b = j < 0 ? 0 : arr2[j];
            int x = a + b + c;
            c = 0;
            // 如果大于2，则进位-1
            if (x >= 2){
                x -= 2;
                c -= 1;
            } else if (x == -1) {
                x = 1;
                c += 1;
            }
            ans.add(x);
        }
        while (ans.size() > 1 && ans.get(ans.size() - 1) == 0){
            ans.remove(ans.size() - 1);
        }
        Collections.reverse(ans);
        return ans.stream().mapToInt(x -> x).toArray();
    }

    @Test
    public void test(){
        addNegabinary(new int[]{1,1,1,1,1},new int[]{1,0,1});
    }
}
