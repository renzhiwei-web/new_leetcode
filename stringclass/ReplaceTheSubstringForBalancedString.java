package stringclass;

public class ReplaceTheSubstringForBalancedString {
    public int balancedString(String s) {
        int[] cnt = new int[4];
        String qwer = "QWER";
        int n = s.length();
        for (int i = 0; i < n; i++) {
            cnt[qwer.indexOf(s.charAt(i))]++;
        }
        int m = n / 4;
        // 如果已经是平衡字符串，则直接返回0
        if(cnt[0] == m && cnt[1] == m && cnt[2] == m && cnt[3] == m){
            return 0;
        }
        int ans = n;
        // 使用滑动窗口，滑动窗口内的子串为待替换子串，如果窗口外子串的任意字符数都大于m，则无法进行实现平衡字符串。
        for (int i = 0,j = 0; i < n; i++) {
            cnt[qwer.indexOf(s.charAt(i))]--;
            while(j <= i && cnt[0] <= m && cnt[1] <= m && cnt[2] <= m && cnt[3] <= m){
                ans = Math.min(ans,i - j + 1);
                cnt[qwer.indexOf(s.charAt(j++))]++;
            }
        }
        return ans;
    }
}
