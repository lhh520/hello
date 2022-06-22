package testproject;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class 车队 {
    public int carFleet(int target, int[] position, int[] speed) {
        int N=position.length;
        double[][]cars=new double[N][2];
        for(int i=0;i<N;i++){
            cars[i][0]=position[i];
            cars[i][1]=(target-position[i])*1.0/speed[i];//记录出来时间
        }
        Arrays.sort(cars, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                return (int) (o1[0]-o2[0]);
            }
        });
        int res=0;
        for(int i=N-1;i>=1;i--){//从后向前看
            if(cars[i][1]<cars[i-1][1]){//说明追不上
                res++;
            }else {
                cars[i-1]=cars[i];
            }
        }
        return res+1;
    }
    @Test
    public void test(){
        int target = 12;
        int[]position =new int[]{10,8,0,5,3};
        int[]speed =new int[]{2,4,1,1,3};
        System.out.println(carFleet(target,position,speed));
    }
}
