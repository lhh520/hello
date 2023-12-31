package 新刷题;

public class 所有蚂蚁掉下来前的最后一刻 {
    public int getLastMoment(int n, int[] left, int[] right) {
        int lastMount=0;
        //每一只蚂蚁相遇就会调转
        for(int ant:left){
            lastMount=Math.max(lastMount,ant);
        }
        for(int ant:right){
            lastMount=Math.max(lastMount,n-ant);
        }
        return lastMount;
    }
}
