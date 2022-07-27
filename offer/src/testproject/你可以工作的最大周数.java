package testproject;

public class 你可以工作的最大周数 {
    public long numberOfWeeks(int[] milestones) {
        int max=Integer.MIN_VALUE;
        long sum=0;
        for(int i=0;i<milestones.length;i++){
            int cur=milestones[i];
            max=Math.max(cur,max);
            sum+=cur;
        }
        long rest=sum-max;//剩下的空位
        if(max-1<=rest){
            return sum;//如果空位可以满足 那么输出的就是减去1
        }else {
            return rest*2+1;//不能满足 那么就是加入在加一个
        }
    }
}
