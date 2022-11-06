package stringclass;

public class GoalParserInterpretation {
    // leetcode 1678 simple 2022/11/6
    // 简单模拟即可
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'G') {
                sb.append("G");
            } else if (command.charAt(i) == '(') {
                if (command.charAt(i + 1) == ')'){
                    sb.append("o");
                }else {
                    sb.append("al");
                }
            }
        }
        return sb.toString();

    }
}
