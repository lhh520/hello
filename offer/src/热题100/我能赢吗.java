package 热题100;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

public class 我能赢吗 {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) return true;
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) return false; //1,..maxChoosable数列总和都比目标和小
        int[] state = new int[maxChoosableInteger + 1];  //state[1]=1表示1被选了

        return backtraceWitMemo(state, desiredTotal, new HashMap<String, Boolean>());
    }

    private boolean backtraceWitMemo(int[] state, int desiredTotal, HashMap<String, Boolean> map) {
        String key = Arrays.toString(state); //这里比较关键，如何表示这个唯一的状态，例如[2,3]和[3,2]都是"0011"，状态一样
        if (map.containsKey(key)) return map.get(key);  //如果已经记忆了这样下去的输赢结果,记忆是为了防止如[2,3]，[3,2]之后的[1,4,5,..]这个选择区间被重复计算

        for (int i = 1; i < state.length; i++){
            if (state[i] == 0){ //如果这个数字i还没有被选中
                state[i] = 1;
                //如果当前选了i已经赢了或者选了i还没赢但是后面对方选择输了
                if (desiredTotal - i <= 0 || !backtraceWitMemo(state, desiredTotal - i, map)) {
                    map.put(key, true);
                    state[i] = 0; //在返回之前回溯
                    return true;
                }
                //如果不能赢也要记得回溯
                state[i] = 0;
            }
        }
        //如果都赢不了
        map.put(key, false);
        return false;
    }
    //
    public boolean canIWin1(int maxChoosableInteger, int desiredTotal){
        if(maxChoosableInteger>=desiredTotal) return true;
        if((1+maxChoosableInteger)*maxChoosableInteger/2<desiredTotal) return false;
        int[]state=new int[maxChoosableInteger+1];//state[1]=1 表示1被选中了
        return backtraceWitMemo1(state,desiredTotal,new HashMap<String,Boolean>());
    }
    public boolean backtraceWitMemo1(int[]state,int desiredTotal,HashMap<String,Boolean>map){
        String key=Arrays.toString(state);
        if (map.containsKey(key)) return map.get(key);
        for(int i=0;i<state.length;i++){
            if(state[i]==0){//数字还没被选中
                state[i]=1;
                if(desiredTotal-i<=0||!backtraceWitMemo1(state,desiredTotal-i,map)){
                    map.put(key,true);
                    state[i]=0;
                    return true;
                }
                state[i]=0;
            }
        }
        //都赢不了
        map.put(key,false);
        return false;
    }
    @Test
    public void test(){
        int maxChoosableInteger = 10, desiredTotal = 11;
        System.out.println(canIWin1(maxChoosableInteger,desiredTotal));
    }


}
