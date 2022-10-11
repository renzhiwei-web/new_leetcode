package stringclass;

public class CheckIfOneStringSwapCanMakeStringsEqual {
    public boolean areAlmostEqual(String s1, String s2) {
    	int len = s1.length();
    	if (len != s2.length()) {
			return false;
		}
    	int a = -1, b = -1;
     	for(int i = 0;i < len;i++) {
    		if (s1.charAt(i) != s2.charAt(i)) {
				if (a == -1) {
					a = i;
				}else if(b == -1){
					b = i;
				}else {
					return false;
				}
			}
    	}
     	if (a == -1 && b == -1) {
			return true;
		}
     	if (a != -1 && b != -1 && s1.charAt(a) == s2.charAt(b) && s1.charAt(b) == s2.charAt(a)) {
			return true;
		}
     	return false;
    }
}
