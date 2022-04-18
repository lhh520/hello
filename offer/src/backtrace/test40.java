package backtrace;

import org.junit.Test;

import java.util.*;

public class test40 {
    List<Integer>list=new ArrayList<>();
    List<List<Integer>>lists=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Deque<Integer> deque = new LinkedList<>();
        Arrays.sort(candidates);
        boolean[] flag = new boolean[candidates.length];
        if(candidates.length==0)
            return lists;
        backtrace(candidates,target,0,flag);
        for(int i=0;i<lists.size();i++){
            System.out.println(lists.get(i).toString());
        }
        return lists;
    }
    public void backtrace(int[] candidates, int target,int index,boolean[] flag){
        if(sum(list)>target){

            return;
        }
        if(sum(list)==target){
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i=index;i<candidates.length&&sum(list)<target;i++){
            if(i>0&&candidates[i]==candidates[i-1]&&!flag[i-1]){
                 continue;
            }
            flag[i]=true;
            list.add(candidates[i]);
            backtrace(candidates,target,i+1,flag);
            list.remove(list.size()-1);
            flag[i]=false;
            //backtrace(candidates,target,i+1,list,lists,flag);
        }

    }
    public int sum(List<Integer>list){
        int sum=0;
        for(int i=0;i<list.size();i++){
            sum=sum+list.get(i);
        }
        return sum;
    }
    @Test
    public void test(){
        int[] candidates=new int[]{2,5,2,1,2};
        List<List<Integer>>lists=combinationSum2(candidates,5);

    }
}
