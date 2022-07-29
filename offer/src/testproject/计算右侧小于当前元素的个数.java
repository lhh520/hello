package testproject;

import java.util.ArrayList;
import java.util.List;

public class 计算右侧小于当前元素的个数 {
    private Pair[] temp;
    // 记录每个数右边元素小于的数量
    private int[] count;
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        count = new int[n];
        temp = new Pair[n];
        Pair[] arr = new Pair[n];
        // 构建 Pair[]
        for (int i = 0; i < n; i++) arr[i] = new Pair(nums[i], i);

        sort(arr, 0, n - 1);

        // int[] -> List
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) ans.add(count[i]);
        return ans;

    }
    public void sort(Pair[]arr,int lo,int hi){
        if(lo==hi) return;
        int mid=lo-(lo-hi)/2;
        sort(arr,lo,mid);
        sort(arr,mid+1,hi);
        merge(arr,lo,mid,hi);
    }
    private void merge(Pair[]arr,int lo,int mid,int hi){
        for(int i=lo;i<=hi;i++) temp[i]=arr[i];
        int index=lo;
        int i=lo,j=mid+1;
        while (i<=mid||j<=hi){
            if(i>mid) arr[index++]=temp[j++];
            else if(j>hi){//表明只剩下右边的数字了
                count[temp[i].id]+=j-mid-1;//右侧的都小于当前的数字
                arr[index++]=temp[i++];
            }else if(temp[i].val>temp[j].val) arr[index++]=temp[j++];//直接插入右边
            else {//插入左边需要考虑j-mid-1
                count[temp[i].id]+=j-mid-1;
                arr[index++]=temp[i++];
            }
        }
    }
}
class Pair{
    int val,id;

    public Pair(int val,int id){
        this.val=val;
        this.id=id;//本来的次序
    }

}
