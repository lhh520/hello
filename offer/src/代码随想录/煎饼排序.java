package 代码随想录;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 煎饼排序 {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer>ret=new ArrayList<>();
        for(int n=arr.length;n>1;n--){
            int index=0;
            for(int i=1;i<n;i++){//找到最大值的index
                if(arr[i]>=arr[index]){
                    index=i;
                }
            }
            //如果已经处在最后部分，则不需要
            if(index==n-1){
                continue;
            }
            reverse(arr,index);//将index转移到最前面
            reverse(arr,n-1);//
            ret.add(index+1);
            ret.add(n);
        }
        return ret;
    }
    public void reverse(int[]arr,int end){
        for(int i=0,j=end;i<j;i++,j--){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
    }
    @Test
    public void test(){
        int[]nums=new int[]{3,2,4,1};
        List<Integer>list=pancakeSort(nums);
        System.out.println(list);
    }
}
