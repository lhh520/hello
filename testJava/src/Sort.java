public class Sort {
    public static void main(String[] args) {
        int[] arr = { 49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22 };
        quicksort(arr,0,arr.length-1);
        System.out.println("排序后：");
        for(int i:arr){
            System.out.println(i);
        }
    }
    public static void quicksort(int[]array,int low,int high){
       if(low<high){
           int index=getIndex(array,low,high);
           quicksort(array,low,index-1);
           quicksort(array,index+1,high);
       }
    }
    public static int getIndex(int[]arr,int low,int high){
        int tmp=arr[low];//当前的基准数据
        while (low<high){
            //当队尾大于基准数据，满足条件，则向前挪动指针
            while (low<high&&arr[high]>=tmp){
                high--;
            }
            //如果队尾元素小于tmp,则需要将赋值给low
            arr[low]=arr[high];
            while (low<high&&arr[low]<=tmp){
                low++;
            }
            //队首元素大于标志，则赋值给后面
            arr[high]=arr[low];
        }
        //跳出循环，low和high相等时，low和high是tmp的正确索引位置
        arr[low]=tmp;
        return low;
    }
}
