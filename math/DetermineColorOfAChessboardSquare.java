package math;

public class DetermineColorOfAChessboardSquare {
    // leetcode 1812 simple 2022/12/8
    // 找规律
    public boolean squareIsWhite(String coordinates) {
        return (coordinates.charAt(0) + coordinates.charAt(1)) % 2 == 1;
    }
}
