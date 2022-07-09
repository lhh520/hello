package 热题100;

import org.junit.Test;

import java.util.Arrays;

public class 完成所有工作的最短时间 {
    public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        int low=0,high=jobs.length-1;
        while (low<high){
            int temp=jobs[low];
            jobs[low]=jobs[high];
            jobs[high]=temp;
            low++;
            high--;
        }
        int l=jobs[0],r=Arrays.stream(jobs).sum();
        while (l<r){
            int mid=(l+r)/2;
            if(check(jobs,k,mid)){
                r=mid;
            }else {
                l=mid+1;
            }
        }
        return l;
    }
    public boolean check(int[]jobs,int k,int mid){
        int[]bucket=new int[k];
        return backtrace(jobs,bucket,0,mid);
    }
    public boolean backtrace(int[]jobs,int[]bucket,int i,int limit){
        if(i>jobs.length){
            return true;
        }
        for(int j=0;j<bucket.length;j++){
            if(bucket[j]+jobs[i]<=limit){
                bucket[j]+=jobs[i];
                if(backtrace(jobs,bucket,i+1,limit)){
                    return true;
                }
                bucket[j]-=jobs[i];
            }
            if(bucket[j]==0||bucket[i]+jobs[i]==limit){
                break;
            }
        }
        return false;
    }

    @Test
    public void test(){
        int[]jobs =new int[]{1,2,4,7,8};
        int k = 2;
        System.out.println(minimumTimeRequired(jobs,k));
    }
}
