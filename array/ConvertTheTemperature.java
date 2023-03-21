package array;

public class ConvertTheTemperature {
    // leetcode 2469 simple 2023/3/21
    // 简单模拟
    public double[] convertTemperature(double celsius) {
        double kelvin = 0;
        double Fahrenheit = 0;
        kelvin = celsius + 273.15;
        Fahrenheit = celsius * 1.80 + 32.00;
        return new double[]{kelvin,Fahrenheit};
    }
}
