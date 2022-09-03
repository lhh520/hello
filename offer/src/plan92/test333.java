package plan92;

import java.util.*;

public class test333 {
    static int max=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int n=Integer.parseInt(str);
        String str1=sc.nextLine();
        String[]strings=str1.split(" ");
        int[]nums=new int[strings.length];

        for(int i=0;i<strings.length;i++){
            nums[i]=Integer.parseInt(strings[i]);
            max=Math.max(max,nums[i]);
        }
        //System.out.println(max);
        //int[]ret=new int[n];
        //System.out.println(Arrays.toString(nums));
        List<Integer>list=new ArrayList<>();
        for(int i=0;i< nums.length;i++){
            list.add(nums[i]);
        }
        //System.out.println(list);
        int[]ret=new int[n];

        for(int i=0;i<list.size();i++){
             List<Integer>temp=new ArrayList<>();
             for(int j=0;j<list.size();j++){
                 temp.add(list.get(j));
             }
             ret[i]=getmax(temp,i);
        }
        for(int i=0;i< nums.length;i++){
            System.out.print(ret[i]);
            System.out.print(" ");
        }
        System.out.println();
    }
    public static int getmax(List<Integer>ret,int index){
        ret.remove(index);
        //System.out.println(ret);
        for(int i=0;i<=max;i++){
            if(!ret.contains(i)){
                return i;
            }
        }
        return 0;
    }
}
