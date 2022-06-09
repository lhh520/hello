package testproject;

import java.util.Random;

public class 非重叠矩形中的随机点 {
    int[][]rects;
    int total;
    int[]presum;
    Random random = new Random();
    public 非重叠矩形中的随机点(int[][] rects) {
        this.rects=rects;//先进行初始化
        presum=new int[rects.length];//面积
        int[]nn=rects[0];
        presum[0]=(nn[2]-nn[0])*(nn[3]-nn[1]);
        total=presum[0];
        int[]area=new int[rects.length];
        for(int i=1;i< rects.length;i++){
            int[]temp=rects[i];
            area[i]=(temp[2]-temp[0]+1)*(temp[3]-temp[1]+1);
            presum[i]=area[i]+presum[i-1];
            total+=area[i];
        }
    }

    public int[] pick() {
        //1。先计算面积
        //2。产生面积随机数  然后计算
        int x= random.nextInt(total)+1;
        //寻找刚好满足条件的面积
        int left=0,right=0;
        int index=0;
        while (left<=right){
            int mid=(right-left)/2+left;
            if(presum[mid]<x){
                index=mid;
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        //找到index 左上角为起始点
        int[]cur=rects[index];
        int xx = random.nextInt(cur[2] - cur[0] + 1) + cur[0];
        int yy = random.nextInt(cur[3] - cur[1] + 1) + cur[1];
        return new int[]{xx, yy};
    }
}
