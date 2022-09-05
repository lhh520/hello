package offertest1;

import java.util.*;

public class testdhdhhd {



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
            System.out.println(getmin(nums,k,x));
        }
    }
    public static int getmin(int[]nums,int k,int x){
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        while (true){
            while (list.get(0)>list.get(1)){
                list.set(0,list.get(0)-x);
                k--;
                if(k==0){
                    Collections.sort(list, new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return o2-o1;
                        }
                    });
                    return list.get(0);
                }
            }
            Collections.sort(list, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });
        }
    }
}
