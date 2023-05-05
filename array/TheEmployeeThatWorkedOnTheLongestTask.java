package array;


public class TheEmployeeThatWorkedOnTheLongestTask {
    public int hardestWorker(int n, int[][] logs) {
        int[] map = new int[n];
        int ans = 0;
        int maxTime = 0;
        int lastTime = 0;
        for (int[] log : logs) {
            int id = log[0];
            int leaveTime = log[1] - lastTime;
            map[id] = Math.max(map[id], leaveTime);
            if (maxTime < leaveTime) {
                maxTime = leaveTime;
                ans = id;
            } else if (maxTime == leaveTime) {
                if (id < ans) {
                    ans = id;
                }
            }
            lastTime = log[1];
        }
        return ans;
    }
}
