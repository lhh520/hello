package 代码随想录;

import org.junit.Test;

import java.util.*;

public class 从双倍数组中还原原数组 {
    public int[] findOriginalArray(int[] changed) {
        if(changed.length%2!=0){
            return new int[]{};
        }
        Arrays.sort(changed);
        Map<Integer,Integer>map=new HashMap<>();
        int cnt=0;
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<changed.length;i++){
            if(map.getOrDefault(changed[i],0)>0){
                cnt++;
                map.put(changed[i],map.get(changed[i])-1);
                list.add(changed[i]/2);
            }else {
                map.put(changed[i]*2,map.getOrDefault(changed[i]*2,0)+1);
            }
        }
        if(cnt!=changed.length/2){
            return new int[]{};
        }
        int[]ans=new int[cnt];
        for(int i=0;i<ans.length;i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
    @Test
    public void test(){
        int[]nums=new int[]{1,3,4,2,6,8};
        int[]uu=findOriginalArray(nums);
        System.out.println(Arrays.toString(uu));
    }
}
