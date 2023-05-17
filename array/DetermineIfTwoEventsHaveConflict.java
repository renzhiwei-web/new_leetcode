package array;

public class DetermineIfTwoEventsHaveConflict {
    // leetcode 2446 simple 2023/5/17
    // 将时间转为当天所在时间分钟数，即可容易的比较时间的大小
    public boolean haveConflict(String[] event1, String[] event2) {
        if (check(event1[1]) < check(event2[0])){
            return false;
        }else if (check(event2[1]) < check(event1[0])){
            return false;
        } else {
            return true;
        }
    }

    private int check(String s) {
        String[] cs = s.split(":");
        return Integer.parseInt(cs[0]) * 60 + Integer.parseInt(cs[1]);
    }
}
