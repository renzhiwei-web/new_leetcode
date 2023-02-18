package array;

import java.util.ArrayList;
import java.util.List;

public class FindPositiveIntegerSolutionForAGivenEquation {
    // leetcode 1237 medium 2023/2/18
    // 由题意可得，可以采用双指针枚举的方法进行解题
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int x = 1,y = 1000; x <= 1000 && y >= 1; x++) {
            while (y >= 1 && customfunction.f(x,y) > z){
                y--;
            }
            if (y >= 1 && customfunction.f(x,y) == z){
                List<Integer> pair = new ArrayList<>();
                pair.add(x);
                pair.add(y);
                ans.add(pair);
            }
        }
        return ans;
    }
}


interface CustomFunction{
    public int f(int x, int y);
}