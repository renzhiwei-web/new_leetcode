package graph;

public class AlphabetBoardPath {
    public String alphabetBoardPath(String target) {
        // leetcode 1138 medium 2023/2/12
        // 曼哈顿距离进行模拟
        var ans = new StringBuilder();
        int x = 0,y = 0;
        for (var ch : target.toCharArray()) {
            int nx = (ch - 'a') / 5;
            int ny = (ch - 'a') % 5;
            var v = nx < x ? "U".repeat(x - nx) : "D".repeat(nx - x);
            var h = ny < y ? "L".repeat(y - ny) : "R".repeat(ny - y);
            ans.append(ch != 'z' ? v + h :h + v).append('!');
            x = nx;
            y = ny;
        }
        return ans.toString();
    }
}
