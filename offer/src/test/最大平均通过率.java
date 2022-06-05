package test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 最大平均通过率 {
    public double maxAverageRatio(int[][] classes, int extraStudents){
        PriorityQueue<double[]>pq=new PriorityQueue<>(new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                double dx=(o1[0]+1)/(o1[1]+1)-o1[0]/o1[1];
                double dy=(o2[0]+1)/(o2[1]+1)-o2[0]/o2[1];
                if(dx>dy){
                    return 1;
                }else if(dx<dy){
                    return -1;
                }else {
                    return 0;
                }
            }
        });
        // 转化为 double，方便小数计算
        for (int[] c : classes) {

            pq.offer(new double[]{c[0], c[1]});
        }
        // 分配学生，每次分配 1 名
        while (extraStudents > 0) {

            double[] maxClass = pq.poll(); //取出能够产生最大影响的班级
            maxClass[0] += 1.0; //通过的人数
            maxClass[1] += 1.0; //班级总人数

            pq.offer(maxClass); //将更新后的重新加入队列中
            extraStudents--;
        }
        // 计算最终结果
        double res = 0;
        while (!pq.isEmpty()) {

            double[] c = pq.poll();
            res += (c[0] / c[1]);
        }
        return res / classes.length;
    }
}
