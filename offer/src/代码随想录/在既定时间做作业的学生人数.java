package 代码随想录;

import org.junit.Test;

public class 在既定时间做作业的学生人数 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int sum=0;
        for(int i=0;i<startTime.length;i++){
            if(queryTime>=startTime[i]&&queryTime<=endTime[i]){
                sum++;
            }
        }
        return sum;
    }


}
