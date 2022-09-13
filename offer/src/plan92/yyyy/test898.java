package plan92.yyyy;
import org.junit.Test;

import java.util.*;
public class test898 {
    public String showDown (String inHand) {
        // write code here
        List<Node>list=new ArrayList<>();
        String[]str=inHand.split(" ");
        Set<Character>set=new HashSet<>();
        for(int i=0;i<str.length;i++){
            char c=str[i].charAt(0);
            int  num=0;
            if(str[i].charAt(1)=='J'){
                num=11;
            }else if(str[i].charAt(1)=='Q'){
                num=12;
            }else if(str[i].charAt(1)=='K'){
                num=13;
            }else if(str[i].length()==3&&str[i].charAt(1)=='1'&&str[i].charAt(2)=='0'){
                num=10;
            } else if(str[i].charAt(1)=='A'){
                num=1;
            }
            else {
                num=str[i].charAt(1)-'0';
            }
            set.add(c);
            //int  num=str[i].charAt(1)-'0';
            Node n1=new Node(c,num);
            list.add(n1);
        }
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.v-o2.v;
            }
        });
       // System.out.println(1);


        if(set.size()==1){
            if(list.get(0).v==1){
                int j=1;
                for(j=2;j<list.size();j++){
                    if(list.get(j).v-list.get(j-1).v!=1){
                        break;
                    }
                }
                if(j==list.size()&&list.get(list.size()-1).v==13){
                    return "HuangJiaTongHuaShun";
                }
            }
            int j=0;
            for(j=1;j<list.size();j++){
                if(list.get(j).v-list.get(j-1).v!=1){
                    break;
                }
            }
            if(j==list.size()){
                return "TongHuaShun";
            }
        }


        int i=0;


            Map<Integer,Integer>map=new HashMap<>();
           Map<Character,Integer>map2=new HashMap<>();
           int[]nums=new int[14];
            boolean flag3=false;
            for(int ii=0;ii<list.size();ii++){
                Node nn=list.get(ii);
                map.put(nn.v,map.getOrDefault(nn.v,0)+1);
                map2.put(nn.c,map2.getOrDefault(nn.c,0)+1);
                if(map.get(nn.v)>=4){//四条
                    return "SiTiao";
                }
                nums[nn.v]++;
                if(map2.get(nn.c)>=5){//四条
                    flag3=true;
                }
            }
            boolean flag1=false,flag2=false;
            int count=0;
            for(Map.Entry<Integer,Integer>entry: map.entrySet()){
                if(entry.getValue()==3){
                    flag1=true;
                }
                if(entry.getValue()==2){
                    count++;
                    flag2=true;
                }
            }
            if(flag1&&flag2){
                return "Hulu";
            }
            //
            if(flag3){
                return "Tonghua";
            }
            //顺子
            int countt=1;
            int max=1;
            for(i=1;i<14;i++){
                if(nums[i]>0){
                    countt++;
                }else {
                    countt=0;
                }
                max=Math.max(max,countt);
                if(max>4){
                    return "ShunZi";
                }
            }

            if(flag1&&flag2==false){
                return "SanTiao";
            }
            if(count==2){
                return "LiangDui";
            }
        if(count==1){
            return "YiDui";
        }
        return "Gaopai";



    }
    class Node{
        char c;
        int v;
        public Node(char c,int v){
            this.c=c;
            this.v=v;
        }
        public char getC() {
            return c;
        }

        public void setC(char c) {
            this.c = c;
        }

        public int getV() {
            return v;
        }

        public void setV(int v) {
            this.v = v;
        }
    }
    @Test
    public void test(){
        String in="SA SK SQ SJ S10 H10 C9";
        System.out.println(showDown(in));
    }
}
