package test;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class 通知所有员工所需的时间 {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Queue<Integer>queue=new LinkedList<>();
        boolean[]flag=new boolean[n];
        int ans=0;
        //找到最大的老板
        queue.add(headID);
        flag[headID]=true;
        while (!queue.isEmpty()){//当栈不为空 还有未通知的人
            int sz=queue.size();
            int time=0;
            for(int i=0;i<sz;i++){
                int temp=queue.poll();//弹出领导
                flag[temp]=true;
                time=Math.max(time,informTime[temp]);//通知的最大时间
                for(int j=0;j<manager.length;j++){
                    if(flag[j]==false&&manager[j]==temp){//如果是当前领导的下属
                        queue.add(j);
                    }
                }
            }
            ans+=time;//表示通知时间
        }
        return ans;
    }
    //深度优先遍历
    public int numOfMinutes1(int n, int headID, int[] manager, int[] informTime){
        if(n==1){
            return 0;//只有一个人，则不需要传递时间
        }
        int[]time=new int[n];//用来存储所有的时间
        //开始进行搜索遍历
        time[headID]=-1;//表示总经理时间比较短
        int ans=0;//表示最终的结果
        for(int i=0;i<n;i++){
            if(time[i]==0)
            time[i]=getTime(manager,informTime,i,time);
            ans=Math.max(ans,time[i]);
        }
        return ans;
    }
    public int getTime(int[] manager, int[] informTime,int cur,int[]time){
        int aim=manager[cur];//获取领导
        //System.out.println(aim);
        if(time[aim]==-1){//如果是领导
            return informTime[aim];//直接返回
        }
        if(time[aim]==0){//还未获取到领导的传递消息时间
            time[aim]=getTime(manager,informTime,aim,time);
        }
        //返回负责人时间以及信息传递时间
        return time[aim]+informTime[aim];//表示为负责人时间和信息传递时间
    }
    @Test
    public void test(){
        int n = 6, headID = 2;
        int[]manager =new int[]{2,2,-1,2,2,2};
        int[]informTime =new int[]{0,0,1,0,0,0};
        System.out.println(numOfMinutes1(n,headID,manager,informTime));
    }
}
