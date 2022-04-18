import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class test134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[]coga=new int[gas.length];
        int max=Integer.MIN_VALUE;
        int index=-1;
        for(int i=0;i<gas.length;i++)
        {
            coga[i]=gas[i]-cost[i];
            if(coga[i]>max)
            {
                index=i;
                max=coga[i];
            }
        }
        int sum=0;
        boolean flag=true;
        for(int j=index;j<gas.length;j++)
        {
            sum=sum+gas[j]-cost[j];
            if(sum<0)
                flag=false;
        }
        for(int i=0;i<index;i++)
        {
            sum=sum+gas[i]-cost[i];
            if(sum<0)
                flag=false;
        }
        if(flag)
        return index;
        else
            return -1;
    }
    //
    public int canCompleteCircuit1(int[] gas, int[] cost)
    {
        int n=gas.length;
        int i=0;
        //从头到尾遍历，并检查以当前加油站为起点
        while (i<n)
        {
            int sumofGas=0;//总共加的油
            int sumofCost=0;//油的消耗
            int count=0;//记录当前的遍历过的点数
            while (count<n)//
            {
                int j=(i+count)%n;//环形遍历
                sumofGas=sumofGas+gas[j];//加上汽油
                sumofCost=sumofCost+cost[j];//加上消耗
                if(sumofCost>sumofGas)//如果当前的消耗比当前的汽油多，说明失败
                    break;
                count++;//反之，就可以遍历下一个节点
            }
            if(count==n)//说明满足条件
                return i;
            else//不满足条件，则从下一个点开始
                i=i+count+1;
        }
        return -1;
    }
    @Test
    public void test()
    {
        int[] gas=new int[]{1,2,3,4,5};
        int[] cost=new int[]{3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas,cost));
    }
}