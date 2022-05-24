package 热题100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 可以攻击国王的皇后 {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        Arrays.sort(queens, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int ii=Math.abs(king[1]-o1[1])+Math.abs(king[0]-o1[0]);
                int jj=Math.abs(king[1]-o2[1])+Math.abs(king[0]-o2[0]);
                return ii-jj;
            }
        });
        int[]flag=new int[8];
        List<List<Integer>>lists=new ArrayList<>();
        for(int i=0;i<queens.length;i++){
            int[]temp=queens[i];
            //判定0
            if(flag[0]==0&&temp[0]==king[0]&&temp[1]<king[1]){
                List<Integer>list=new ArrayList<>();
                list.add(temp[0]);
                list.add(temp[1]);
                lists.add(new ArrayList<>(list));
                flag[0]=1;
            }else if(flag[1]==0&&temp[0]==king[0]&&temp[1]>king[1]){//判定1
                List<Integer>list=new ArrayList<>();
                list.add(temp[0]);
                list.add(temp[1]);
                lists.add(new ArrayList<>(list));
                flag[1]=1;
            }else if(flag[2]==0&&temp[1]==king[1]&&temp[0]<king[0]){//判定2
                List<Integer>list=new ArrayList<>();
                list.add(temp[0]);
                list.add(temp[1]);
                lists.add(new ArrayList<>(list));
                flag[2]=1;
            }else if(flag[3]==0&&temp[1]==king[1]&&temp[0]>king[0]){//判定3
                List<Integer>list=new ArrayList<>();
                list.add(temp[0]);
                list.add(temp[1]);
                lists.add(new ArrayList<>(list));
                flag[3]=1;
            }else if(flag[4]==0&&temp[0]<king[0]&&temp[1]<king[1]&&(Math.abs(temp[0]-king[0])==Math.abs(temp[1]-king[1]))){//判定4
                List<Integer>list=new ArrayList<>();
                list.add(temp[0]);
                list.add(temp[1]);
                lists.add(new ArrayList<>(list));
                flag[4]=1;
            }else if(flag[5]==0&&temp[0]>king[0]&&temp[1]>king[1]&&(Math.abs(temp[0]-king[0])==Math.abs(temp[1]-king[1]))){//判定4
                List<Integer>list=new ArrayList<>();
                list.add(temp[0]);
                list.add(temp[1]);
                lists.add(new ArrayList<>(list));
                flag[5]=1;
            }else if(flag[6]==0&&temp[0]>king[0]&&temp[1]<king[1]&&(Math.abs(temp[0]-king[0])==Math.abs(temp[1]-king[1]))){//判定4
                List<Integer>list=new ArrayList<>();
                list.add(temp[0]);
                list.add(temp[1]);
                lists.add(new ArrayList<>(list));
                flag[6]=1;
            }else if(flag[7]==0&&temp[0]<king[0]&&temp[1]>king[1]&&(Math.abs(temp[0]-king[0])==Math.abs(temp[1]-king[1]))){//判定4
                List<Integer>list=new ArrayList<>();
                list.add(temp[0]);
                list.add(temp[1]);
                lists.add(new ArrayList<>(list));
                flag[7]=1;
            }
        }
        return lists;
    }
    @Test
    public void test(){
        int[][]queens =new int[][]{{0,0},{1,1},{2,2},{3,4},{3,5},{4,4},{4,5}};
        int[]king =new int[]{3,3};
        List<List<Integer>>mm=queensAttacktheKing(queens,king);
        System.out.println(mm.toString());
    }
}
