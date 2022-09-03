package plan92;
import java.util.*;
public class 最接近的三数之和 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        int best=10000000;
        //
        for(int i=0;i<n;i++)
        {
            if(i>0&&nums[i]==nums[i-1])
                continue;
            //使用双指针枚举b,c
            int j=i+1,k=n-1;
            while(j<k)
            { //双指针枚举 b,c
                int sum=nums[i]+nums[j]+nums[k];
                //如果和为target,直接返回答案
                if(sum==target)
                    return target;
                //根据差值更新答案
                if(Math.abs(sum-target)<Math.abs(best-target))
                    best=sum;
                if(sum>target)
                {
                    //如果和大于target,移动c对应的指针
                    int k0=k-1;
                    while(j<k0&&nums[k0]==nums[k])
                        k0--;
                    k=k0;
                }
                else{
                    //如果和小于target,移动b对应的指针
                    int j0=j+1;
                    //移动到下一个不相等的元素
                    while(j0<k&&nums[j0]==nums[j])
                        j0++;
                    j=j0;
                }
            }
        }
        return best;
    }
}
