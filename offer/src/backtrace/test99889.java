package backtrace;

import java.util.*;

public class test99889 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ss=in.nextLine();
        String yy=ss;
        Map<String,Integer>map=new HashMap<>();
        char[]chars=ss.toCharArray();
        int i=0;
        char pre=chars[0];
        int j=1;
        while (j< chars.length){
             while (j<chars.length&&chars[j]==pre){
                 j++;
             }
             String sb=ss.substring(i,j);
            //System.out.println(sb);
             if(sb.length()>=1){
                  map.put(sb, map.getOrDefault(sb,0)+1);
             }
             i=j;
             if(j>= chars.length){
                 break;
             }
             pre=chars[j];
        }

        List<String>list=new ArrayList<>();
        for(Map.Entry<String,Integer>entry: map.entrySet()){
             if(entry.getValue()>1&&entry.getKey().length()>=4){
                  list.add(entry.getKey());
             }
        }
        if(list.size()==0){
            System.out.println(ss);
            return;
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length()-o1.length();
            }
        });
        Map<String,Integer>map1=new HashMap<>();
        int hh=1;
        for(int k=0;k<list.size();k++){
             String temp=list.get(k);
             map1.put(temp,hh);
             ss=ss.replaceAll(temp,"["+hh+"]");
             hh++;
        }
        StringBuilder sb=new StringBuilder();
        for(Map.Entry<String,Integer>entry: map1.entrySet()){
            sb.append(entry.getValue()+entry.getKey());
        }
        sb.append("@");
        System.out.println("compress:"+sb.append(ss).toString());
        System.out.println("decompression:"+yy);
    }
}
//compress:1kkkkkkkkkk2oooooo@aail[2][1]lw[1]ejirlkkkadkkfau[1]uiiw[2]el
//        decompression:aailooooookkkkkkkkkklwkkkkkkkkkkejirlkkkadkkfaukkkkkkkkkkuiiwooooooel

