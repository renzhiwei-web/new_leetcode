package bitCompute;

public class BianryNumberToStringLcci {
    // leetcode 2875 medium 2023/3/2
    // 十进制小数转二进制的方法
    public String printBin(double num) {
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        int i = 0;
        while(num != 0 && i < 32){
            num *= 2;
            int v = (int) num;
            num -= v;
            sb.append(v);
            i++;
        }
        if (i >= 32){
            return "ERROR";
        }
        return sb.toString();
    }
}
