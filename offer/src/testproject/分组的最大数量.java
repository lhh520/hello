package testproject;

public class 分组的最大数量 {
    public int maximumGroups(int[] grades) {
        long len=grades.length;
        long ans=1;
        long l=1,r=len;
        while (l<=r){
            long m=(l+r)/2;
            long need=(1+m)*m/2;//分为m组 需要need个人
            if(need>len){//如果大于总数
                r=m-1;
            }else {
                ans=m;
                l=m+1;
            }
        }
        return (int)ans;
    }
}
