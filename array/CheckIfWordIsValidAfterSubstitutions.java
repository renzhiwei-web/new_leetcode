package array;

import java.util.Stack;

public class CheckIfWordIsValidAfterSubstitutions {
    // leetcode 1003 medium 2023/5/3
    // 使用栈数据结构进行解题，具体的步骤与括号匹配相类似，但此题是三个字符匹配
    public boolean isValid(String s) {
        char[] cs = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == 'a'){
                stack.push(cs[i]);
            } else if (cs[i] == 'b') {
                if (stack.empty()){
                    return false;
                }
                if (stack.peek() != 'a'){
                    return false;
                }
                stack.push(cs[i]);
            } else {
                if (stack.empty()){
                    return false;
                }
                if (stack.peek() == 'b'){
                    stack.pop();
                    if (stack.peek() == 'a'){
                        stack.pop();
                    }else {
                        return false;
                    }
                }else {
                    return false;
                }
            }

        }
        return stack.empty();
    }

    private boolean isValid1(String s){
        if (s.length() % 3 > 0) {
            return false;
        }
        StringBuilder t = new StringBuilder();
        for (char c : s.toCharArray()) {
            t.append(c);
            if (t.length() >= 3 && "abc".equals(t.substring(t.length() - 3))) {
                t.delete(t.length() - 3, t.length());
            }
        }
//        return t.isEmpty(); // jdk 15 之后只有此方法
        return t.toString().equals("");
    }
}
