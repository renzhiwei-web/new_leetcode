package stringclass;

public class MinimumSwapsToMakeStringsEqual {
    public int minimumSwap(String s1, String s2) {
        int xy = 0,yx = 0;
        for (int i = 0; i < s1.length(); i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if (ch1 == ch2){
                continue;
            } else if (ch1 == 'x') {
                xy++;
            }else {
                yx++;
            }
        }
        if (((xy + yx) & 1) == 1) {
            return -1;
        }
        return xy / 2 + yx / 2 + xy % 2 + yx % 2;
    }
}
