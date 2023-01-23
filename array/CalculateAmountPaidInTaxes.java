package array;

public class CalculateAmountPaidInTaxes {
    public double calculateTax(int[][] brackets, int income) {
        double ans = 0;
        for (int i = 0; i < brackets.length && income > 0; i++) {
            if (income < brackets[i][0]){
                double temp = 0;
                if (i == 0){
                    temp = income * brackets[i][1] / 100.0;
                }else {
                    temp = (income - brackets[i - 1][0]) * brackets[i][1] / 100.0;
                }
                ans += temp;
                break;
            }else {
                double temp = 0;
                if (i == 0){
                    temp = brackets[0][0] * brackets[0][1] / 100.0;
                }else {
                    temp = (brackets[i][0] - brackets[i - 1][0]) * brackets[i][1] / 100.0;
                }
                ans += temp;
            }
        }
        return ans;
    }

    public double calculateTax1(int[][] brackets, int income) {
        int ans = 0, prev = 0;
        for (int[] e : brackets) {
            int upper = e[0], percent = e[1];
            ans += Math.max(0, Math.min(income, upper) - prev) * percent;
            prev = upper;
        }
        return ans / 100.0;
    }
}
