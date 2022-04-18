package Hash;

import org.junit.Test;

import java.util.*;

public class test347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap();
        Set<Integer>set=new HashSet<>();
        List<Integer>list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(set.add(nums[i])){
                list.add(nums[i]);
            }
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2)-map.get(o1);
            }
        });
        int[]ans=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
    @Test
    public void test(){
        int[]ans=new int[]{1,1,1,2,2,3};
        int []nums=topKFrequent(ans,2);
        System.out.println(Arrays.toString(nums));
    }
}
