package test;

public class 航班预订统计 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[]ans=new int[n];
        for(int[]book:bookings){
            int left=book[0];
            int right=book[1];
            int count=book[2];
            for(int i=left-1;i<=right-1;i++){
                ans[i]=ans[i]+count;
            }
        }
        return ans;
    }
}
