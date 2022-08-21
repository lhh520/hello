package mei01;

import org.junit.Test;

import java.util.*;

public class test06 {
    public int get(int[]nums){
        Map<Integer,List<Integer>>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            List<Integer>list=map.getOrDefault(nums[i],new ArrayList<>());
            list.add(i);
            map.put(nums[i],new ArrayList<>(list));
        }
        int ret=0;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                Set<Integer>set=new HashSet<>();
                if(nums[j]>nums[i]&&!set.contains(nums[j])){
                    set.add(nums[j]);
                    List<Integer>list=map.get(nums[j]);
                    int a=0,b=0;
                    for(int ii:list){
                        if(ii<i){
                            a++;
                        }
                        if(ii>i){
                            b++;
                        }
                    }
                    if(a>0&&b>0)
                    ret+=a*b;
                }
            }
        }
        return ret;
    }
    @Test
    public void test(){
        int[]nums=new int[]{3,1,3,4,3,4};
        System.out.println(get(nums));
    }
}
