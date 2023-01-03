package stringclass;

public class CheckIfNumbersAreAscendingInASentence {
    public boolean areNumbersAscending(String s) {
        String[] cs = s.replaceAll("[a-z]","").split(" ");
        int last = -1;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i].length() <= 0){
                continue;
            }
            if (Integer.parseInt(cs[i]) <= last){
                return false;
            }
            last = Integer.parseInt(cs[i]);
        }
        return true;
    }
}
