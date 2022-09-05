package offertest1;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.*;

public class test0dddd {
    public static void main(String[] args) {

            Scanner in = new Scanner(System.in);
            String str=in.nextLine();
            String[]yy=str.split(" ");
            int n=Integer.parseInt(yy[0]);
            int k=Integer.parseInt(yy[1]);
            int x=Integer.parseInt(yy[2]);
            String str1=in.nextLine();
            String[]nn1=str1.split(" ");
            int[]nums=new int[n];
            for(int i=0;i<n;i++){
                nums[i]=Integer.parseInt(nn1[i]);
            }


            //System.out.println(Arrays.toString(nums));
            if(nums.length==1){
                System.out.println(nums[0]-k*x);
                return;
            }else {
                Arrays.sort(nums);
                if(nums[nums.length-1]-k*x>=nums[nums.length-2]){
                    System.out.println(nums[nums.length-1]-k*x);
                    return;
                }
                List<Integer>list=new ArrayList<>();
                for(int i=0;i<n;i++){
                    list.add(nums[i]);
                }
                System.out.println(getmin(nums,k,x));
            }

    }
    public static int minMax (ArrayList<Integer> a, int k, int x) {
        // write code here
        // 初始化数据
        ArrayList<Integer> alist = new ArrayList();
        alist.add(0);
        alist.addAll(a);

        // 建堆
        for (int i=alist.size()/2; i>0; i--) {
            adjust(alist,i,alist.size());
        }

        // k次操作，每次操作完重新建堆
        for (int j=k; j>0; j--) {
            alist.set(1,alist.get(1)-x);
            adjust(alist,1,alist.size());
        }
        return alist.get(1);
    }

    public static void adjust(ArrayList<Integer> arrayList, int k, int len) {

        arrayList.set(0,arrayList.get(k)); // 用arrayList[0]暂存子树的根节点

        for (int i = 2*k; i < len; i*=2) {  // 根顶元素下坠
            if(i+1 < len && arrayList.get(i) < arrayList.get(i+1)) { //左右子元素比较，取最大的子元素
                i++;
            }
            if( arrayList.get(0) >= arrayList.get(i) ) { // 父元素更大，不做处理
                break;
            } else {
                arrayList.set(k,arrayList.get(i));  // 将子元素替换父元素
                k = i;
            }
        }
        arrayList.set(k,arrayList.get(0));  //将被筛选的结点的值放入最终位置
    }
    public static int getmin(int[]nums,int k,int x){
        PriorityQueue<Integer>pq=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        int i=0;
        while (i<k){
            int num=pq.poll();
            num-=x;
            pq.add(num);
            i++;
        }
        return pq.peek();
    }




}
