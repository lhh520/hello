package back;
import org.junit.Test;

import java.util.*;
public class 有效三角形的个数 {
    List<Integer>list=new ArrayList<>();
    List<List<Integer>>lists=new ArrayList<>();
    boolean[]flag;
    int num=0;
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int len=nums.length;
        flag=new boolean[len];
        backtrace(nums,0);
        return num;
    }
    public void backtrace(int[]nums,int index){
        if(list.size()==3){
            Collections.sort(list);
            if(list.get(0)+list.get(1)>list.get(2)){
                num++;
            }
        }
        for(int i=index;i<nums.length;i++){
//            if(i>0&&nums[i-1]==nums[i]&&flag[i-1]==false){
//                continue;
//            }
            list.add(nums[i]);
            flag[i]=true;
            backtrace(nums,i+1);
            list.remove(list.size()-1);
            flag[i]=false;
        }
    }
    //
    public int triangleNumber1(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int left=i+1,right=n-1,k=j;
                while (left<=right){
                    int mid=(left+right)/2;
                    if(nums[mid]<nums[i]+nums[j]){
                        k=mid;
                        left=mid+1;
                    }else {
                        right=mid-1;
                    }
                }
                ans+=k-j;
            }

        }
        return ans;
    }
    @Test
    public void test(){
        int[]nums=new int[]{2,2,3,4};
        System.out.println(triangleNumber(nums));
    }
}
