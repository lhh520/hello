package test;

import org.junit.Test;

import java.util.Arrays;

public class 下一个更大的元素 {
    public int nextGreaterElement(int n){
        char[]a=(""+n).toCharArray();
        //从后往前 找到第一个最小值
        int i;
        for(i=a.length-2;i>=0;i--){
            if(a[i]<a[i+1]){
                break;
            }
        }
        if (i < 0)
            return -1;
        //找到j
        int j;
        for(j=a.length-1;j>0;j--){
            if(a[j]>a[i]){
                break;
            }
        }
        //交换 i，j
        swap(a,i,j);
        //交换完成 开始逆序
        reverse(a,i+1);
        //System.out.println(Arrays.toString(a));
        try {
            return Integer.parseInt(new String(a));
        }catch (Exception e){
            return -1;
        }
    }
    public void swap(char[]a,int i,int j){
        char temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    public void reverse(char[]a,int i){
        int r=a.length-1;
        while (i<r){
            char temp=a[i];
            a[i]=a[r];
            a[r]=temp;
            i++;
            r--;
        }
    }
    @Test
    public void test(){
        int n=21;
        int kk=nextGreaterElement(n);
        System.out.println(kk);
    }
}
