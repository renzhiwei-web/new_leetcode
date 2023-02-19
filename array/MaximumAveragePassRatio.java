package array;

import java.util.PriorityQueue;

public class MaximumAveragePassRatio {
    // leetcode 1792 medium 2023/2/19
    // 根据题意可得，由于原来的通过率已经确定，只需要计算新添加的学生对班级通过率的增加即可
    // 通过最大化班级通过率的增量，即可解题
    // 需重写优先级队列的比较方法
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
        // 定义优先队列，优先级按照增加一名学生之后能够产生的最大贡献来排序
        PriorityQueue<double[]> queue = new PriorityQueue<>((o1, o2) -> {
            double x = ((o2[0] + 1) / (o2[1] + 1) - o2[0] / o2[1]);
            double y = ((o1[0] + 1) / (o1[1] + 1) - o1[0] / o1[1]);
            if (x > y) return 1;
            if (x < y) return -1;
            return 0;
        });

        // 转化为double
        for (var c : classes) {
            queue.offer(new double[]{c[0],c[1]});
        }
        // 分配学生，每次分配1名
        while(extraStudents > 0){
            double[] maxClass = queue.poll();// 取出能够产生最大影响的班级
            maxClass[0] += 1.0;
            maxClass[1] += 1.0;

            queue.offer(maxClass);
            extraStudents--;
        }
        // 计算最终结果
        double ans = 0;
        while (!queue.isEmpty()){
            double[] c = queue.poll();
            ans += (c[0] / c[1]);
        }
        return ans / n;
    }
}
