package array;

public class CountDaysSpentTogether {
    // leetcode 2409 simple 2023/4/17
    // 简单的思想是计算arriveAlice等是一年的第几天，然后利用最早的离开时间-最迟的到达时间即可
    static final int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
    int[] presum = new int[13];
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        for (int i = 0; i < days.length; i++) {
            presum[i + 1] = presum[i] + days[i];
        }
        int arriveAliceDay = countDay(arriveAlice,presum);
        int arriveBobDay = countDay(arriveBob,presum);
        int leaveAliceDay = countDay(leaveAlice,presum);
        int leaveBobDay = countDay(leaveBob,presum);
        int arrive = Math.max(arriveAliceDay,arriveBobDay);
        int leave = Math.min(leaveAliceDay,leaveBobDay);
        int ans = leave - arrive + 1;
        return Math.max(ans, 0);
    }

    private int countDay(String arrive) {
        String[] s = arrive.split("-");
        int ans = 0;
        int month = Integer.parseInt(s[0]);
        int day = Integer.parseInt(s[1]);
        for (int i = 0; i < month - 1; i++) {
            ans += days[i];
        }
        ans += day;
        return ans;
    }

    private int countDay(String arrive,int[] presum) {
        String[] s = arrive.split("-");
        int ans = 0;
        int month = Integer.parseInt(s[0]);
        int day = Integer.parseInt(s[1]);
        ans += presum[month - 1];
        ans += day;
        return ans;
    }
}
