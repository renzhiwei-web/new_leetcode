package array;

import java.util.Arrays;

public class NumberOfStudentsUnableToEatLunch {
    public int countStudents(int[] students, int[] sandwiches) {

        /* 错误的解法，没有考虑 直到队列里所有的学生都不喜欢栈顶的三明治
        int counts_0_student = 0;
        int counts_1_student = 0;
        for (int stuedent : students) {
            if (stuedent == 0) {
                counts_0_student++;
            } else {
                counts_1_student++;
            }
        }

        int counts_0_sandwich = 0;
        int counts_1_sandwich = 0;
        for (int sandwich : sandwiches) {
            if (sandwich == 0){
                counts_0_sandwich++;
            }else {
                counts_1_sandwich++;
            }
        }

        return Math.abs(counts_0_student - counts_0_sandwich) + Math.abs(counts_1_student - counts_1_sandwich);

         */

        // 模拟算法
        // s1是students数组中所有元素的总和，由题意设定可知，s1是1元素的个数
        int s1 = Arrays.stream(students).sum();
        // s0 是0 元素的个数
        int s0 = students.length - s1;
        // 遍历数组，模拟算法
        for (int i = 0; i < sandwiches.length; i++) {
            // 如果当前数组的栈顶元素是0，且还有0学生，则可以分配
            if (sandwiches[i] == 0 && s0 > 0) {
                s0--;
            // 同理
            } else if (sandwiches[i] == 1 && s1 > 0) {
                s1--;
            } else {
                // 如果当前数组的栈顶元素不能分配给其他学生，则剩下其他学生都不可以分配
                break;
            }
        }
        return s0 + s1;
    }
}
