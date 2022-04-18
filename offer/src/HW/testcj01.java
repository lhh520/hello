package HW;

import java.util.*;

public class testcj01 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String ss=sc.nextLine();
        String[]sss=ss.split(" ");
        int top=Integer.valueOf(sss[0]);
        int num=Integer.valueOf(sss[1]);
        HashMap<String,int[]>map=new HashMap();//int[] fre,t s

        while (num-->0){
            String t1=sc.nextLine();
            String t2=sc.nextLine();
            String[]tt1=t1.split(" ");
            String[]tt2=t2.split(" ");
            for(int i=0;i<tt1.length;i++){
                if(map.containsKey(tt1[i])){
                    int[]temp=map.get(tt1[i]);
                    temp[0]=temp[0]+3;
                    map.put(tt1[i],temp);
                }else {
                    int[]temp=new int[]{3,num*100+i,0};
                    map.put(tt1[i],temp);
                }
            }

            for(int i=0;i<tt2.length;i++){
                if(map.containsKey(tt2[i])){
                    int[]temp=map.get(tt2[i]);
                    temp[0]=temp[0]+1;
                    map.put(tt2[i],temp);
                }else {
                    int[]temp=new int[]{1,0,num*100+i};
                    map.put(tt2[i],temp);
                }
            }
            //进行哈希排序
            List<String>strs=new ArrayList<>();
            int j=0;
            for(Map.Entry<String,int[]>entry:map.entrySet()){
                strs.add(entry.getKey());
                j++;
            }
            Collections.sort(strs, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    int[]t1=map.get(o1);
                    int[]t2=map.get(o2);
                    if(t1[0]==t2[0]){
                        if(t1[1]==t2[1]){
                            return t2[2]-t1[2];
                        }else
                            return t2[1]-t1[1];
                    }
                    return t1[0]-t2[0];
                }
            });
            for(int i=0;i<top;i++){
                System.out.println(strs.get(i));
            }

        }
    }
}
