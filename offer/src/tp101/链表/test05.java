package tp101.链表;

import java.util.*;

public class test05 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String in=sc.nextLine();
        String[]nnn=in.split(" ");
        int n=Integer.parseInt(nnn[0]),m=Integer.parseInt(nnn[1]);
        String t=sc.nextLine();
        String[] cc=t.split(" ");
        int[]nums=new int[cc.length];
        for(int i=0;i<cc.length;i++){
            nums[i]=Integer.parseInt(cc[i]);
        }
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(i+1);
        }
        for(int i=0;i<nums.length;i++){
            int index=list.indexOf(nums[i]);
            list.remove(index);
            list.add(0,nums[i]);
        }
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i));
            if(i!=list.size()-1){
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
