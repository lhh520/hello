package testproject;

public class 部分排序 {
    public int[] subSort(int[] array) {
        if(array==null||array.length<=1){
            return new int[]{-1,-1};
        }
        int n=array.length;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int left=-1,right=-1;
        for(int i=0;i<n;i++){
            if(array[i]<max){//一旦出现 小于左边最大值的情况 说明需要移动
                right=i;
            }else {
                max=array[i];
            }
        }
        //
        for(int i=n-1;i>=0;i--){
            if(array[i]>min){
                left=i;
            }else {
                min=array[i];
            }
        }
        return new int[]{left,right};
    }
}
