package 代码随想录二刷.贪心;

public class 加油站 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum=0;
        int min=0;
        for(int i=0;i<gas.length;i++){
            sum+=(gas[i]-cost[i]);
            min=Math.min(sum,min);
        }
        if(sum<0) return -1;//表示一周无论如何也到不了终点
        if(min>=0) return 0;//表示从0开始
        for(int i=gas.length-1;i>0;i--){//
            min+=(gas[i]-cost[i]);
            if(min>=0) return i;
        }
        return -1;
    }
}
