package dp;

import java.util.*;

public class testddd {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<String>list=new ArrayList<>();
        while (sc.hasNextLine()){
            String  read=sc.nextLine();
            if(read==null||read.isEmpty()){
                break;
            }
            String[]ar=read.split(" ");
            int n=Integer.parseInt(ar[0]);
            int m=Integer.parseInt(ar[1]);
            int turn=n/m;
            if(n%(m+1)==0){
                list.add("Wildhunte");
            }else {
                list.add("Gerlot");
            }
//            if(n%m==0){
//                if(turn%2!=0){
//                    list.add("Gerlot");
//                }else {
//                    list.add("Wildhunte");
//                }
//            }else {
//                if(turn%2!=0){
//                    list.add("Wildhunte");
//                }else {
//                    list.add("Gerlot");
//                }
//            }


        }
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
