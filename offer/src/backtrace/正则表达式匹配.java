package backtrace;

import org.junit.Test;

import java.util.Arrays;

public class 正则表达式匹配 {
//    private int[]temp;
//    public void sort(int[]nums){
//        temp=new int[nums.length];
//        sort(nums,0,nums.length-1);
//    }
//    public void sort(int[]nums,int lo,int hi){
//        if(lo==hi) return;
//        int mid=(lo+hi)/2;
//        sort(nums,lo,mid);
//        sort(nums,mid+1,hi);
//        merge(nums,lo,mid,hi);
//    }
//    public void merge(int[]nums,int lo,int mid,int hi){
//        //lo mid hi 三者进行
//       for(int i=lo;i<=hi;i++){
//           temp[i]=nums[i];//复制
//       }
//       int cnt=lo;
//       int i=lo,j=mid+1;
//       while (i<=mid||j<=hi){
//           if(i>mid)nums[cnt++]=temp[j++];//归并排序，如果大于当前值
//           else if(j>hi) nums[cnt++]=temp[i++];
//           else if(temp[i]<=temp[j]){
//               nums[cnt++]=temp[i++];
//           }else {
//               nums[cnt++]=temp[j++];
//           }
//       }
//    }
    //归并排序
    private int[]temp;
    public void sort(int[]nums){
        temp=new int[nums.length];
        sort(nums,0,nums.length-1);
    }
    public void sort(int[]nums,int lo,int hi){
        if(lo==hi){
            return;
        }
        int mid=(lo+hi)/2;
        sort(nums,lo,mid);
        sort(nums,mid+1,hi);
        merge(nums,lo,mid,hi);
    }
    public void merge(int[]nums,int lo,int mid,int hi){
         for(int i=lo;i<=hi;i++){
             temp[i]=nums[i];
         }
         int i=lo,j=mid+1,cnt=lo;
         while (i<=mid||j<=hi){
             if(i>mid) nums[cnt++]=temp[j++];
             else if(j>hi) nums[cnt++]=temp[i++];
             else if(temp[i]<temp[j]) nums[cnt++]=temp[i++];
             else nums[cnt++]=temp[j++];
         }
    }



    @Test
    public void test(){
        int[]nums=new int[]{1,32,3,2,3,2,3};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
