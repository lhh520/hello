package 代码随想录;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 给定数字能组成的最大时间 {
    public String largestTimeFromDigits(int[] arr) {
        Arrays.sort(arr);
        if(arr[0]>2){
            return "";
        }
        int n=arr.length;
        boolean[]flag=new boolean[n];
        StringBuilder sb=new StringBuilder();
        int first=-1;
        //第一位找到了
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]<=2){
                flag[i]=true;
                first=arr[i];
                sb.append(arr[i]);
                break;
            }
        }
        //
        for(int i=arr.length-1;i>=0;i--){
            if(first==2){
            if(arr[i]<=3&&!flag[i]){
                flag[i]=true;
                sb.append(arr[i]);
                break;}
            }else {
                if(arr[i]<=9&&!flag[i]){
                    flag[i]=true;
                    sb.append(arr[i]);
                    break;}
            }
        }
        sb.append(':');
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]<=6&&!flag[i]){
                flag[i]=true;
                sb.append(arr[i]);
                break;
            }
        }
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]<=6&&!flag[i]){
                flag[i]=true;
                sb.append(arr[i]);
                break;
            }
        }
        if(sb.length()==5){
            return sb.toString();
        }
        return "";
    }
    @Test
    public void test(){
        //[0,4,0,0]
        int[]arr=new int[]{0,4,0,0};
        largestTimeFromDigits(arr);
    }
}
