package 热题100;

public class 跳跃游戏2 {
    public int jump(int[]nums){
        int length= nums.length;
        int end=0;
        int maxPosition=0;
        int steps=0;
        for(int i=0;i<length-1;i++){
            maxPosition=Math.max(maxPosition,i+nums[i]);
            if(i==end){
                steps++;
                end=maxPosition;
            }
        }
        return steps;
    }
}
