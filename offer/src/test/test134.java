package test;

public class test134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    for(int i=0;i<cost.length;i++){
        int cur=gas[i]-cost[i];//起点剩余流量
        int index=(i+1)%cost.length;//下一个起点
        while (cur>0&&index!=i){
            cur=cur+gas[index]-cost[index];//在当前的节点获取的油量
            index=(index+1)%cost.length;//更新获取下一个新的起点
        }
        if(cur>=0&&index==i)
            return i;
    }
    return -1;
    }
    public int canCompleteCircuit1(int[] gas, int[] cost){
        int totalgas=0;
        int cursum=0;
        int start=0;
        for(int i=0;i<cost.length;i++){
             cursum=cursum+gas[i]-cost[i];//表示当前的油量
             totalgas=totalgas+gas[i]-cost[i];
             if(cursum<0){
                 start=i+1;
                 cursum=0;
             }
        }
        if(totalgas<0){//如果总和小于0，则一定不可能旋转一圈
            return -1;
        }
        return start;
    }
}
