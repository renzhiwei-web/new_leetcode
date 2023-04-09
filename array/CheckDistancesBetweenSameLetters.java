package array;

public class CheckDistancesBetweenSameLetters {
    // leetcode 2399 simple 2023/4/9
    // 简单模拟
    public boolean checkDistances(String s, int[] distance) {
        int[] d = new int[26];
        for (int i = 1,n = s.length(); i <= n; i++) {
            int j = s.charAt(i - 1) - 'a';
            if (d[j] > 0 && i - d[j] - 1 != distance[j]){
                return false;
            }
            d[j] = i;
        }
        return true;
    }
}
