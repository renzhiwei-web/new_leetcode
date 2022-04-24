package stringclass;

public class LicenseKeyFormatting {
	// leetcode 482 simple 2022/4/24
	// 从后往前遍历比顺序遍历方便
    public String licenseKeyFormatting(String s, int k) {
    	StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1, cnt = 0; i >= 0; i--) {
            if (s.charAt(i) == '-') continue;
            if (cnt == k && (cnt = 0) >= 0) sb.append("-");
            sb.append(s.charAt(i));
            cnt++;
        }
        return sb.reverse().toString().toUpperCase();
    }
}
