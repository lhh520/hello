package testproject;

public class 访问所有点的最小时间 {
    public int minTimeToVisitAllPoints(int[][] points) {
        int sum=0;
        for(int i=1;i<points.length;i++){
            int[] cur=points[i];
            int[] pre=points[i-1];
            int len=0;
            if(cur[0]==pre[0]){//
                len=Math.abs(cur[1]-pre[1]);
            }else if(cur[1]==pre[1]){
                len=Math.abs(cur[0]-pre[0]);
            }else {
                if(Math.abs(cur[1]-pre[1])==Math.abs(cur[0]-pre[0])){
                    len=Math.abs(cur[1]-pre[1]);
                }else{
                    len = Math.max(Math.abs(cur[1] - pre[1]), Math.abs(cur[0] - pre[0]));

                }
            }
            sum+=len;
        }
        return sum;
    }
}
