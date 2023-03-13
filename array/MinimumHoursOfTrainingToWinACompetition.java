package array;

public class MinimumHoursOfTrainingToWinACompetition {
    // leetcode 2383 simple 2023/3/13
    // 简单模拟即可
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int len = energy.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            // 此处可以优化，直接一步到位
            while (initialEnergy <= energy[i]){
                initialEnergy++;
                ans++;
            }
            while (initialExperience <= experience[i]){
                initialExperience++;
                ans++;
            }
            initialEnergy -= energy[i];
            initialExperience += experience[i];
        }
        return ans;
    }

    public int minNumberOfHours1(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int len = energy.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += energy[i];
        }
        int ans = Math.max(0,sum - initialEnergy + 1);
        for (int x : experience) {
            if (initialExperience <= x) {
                ans += x - initialExperience + 1;
                initialExperience = x + 1;
            }
            initialExperience += x;
        }
        return ans;
    }
}
