package offertest1;

import org.junit.Test;

import java.util.*;

public class offer56 {
    public int[] singleNumbers(int[] nums) {
        Arrays.sort(nums);
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<nums.length;i++){
        if(!stack.isEmpty()&&stack.peek()==nums[i]){
            stack.pop();
            continue;
        }
        stack.push(nums[i]);
       }
        int[]nu=new int[2];
        int i=0;
        Iterator<Integer>iterator=stack.iterator();
        while (iterator.hasNext()){
            nu[i]=iterator.next();
            i++;
        }
        return nu;
    }
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            if(entry.getValue()==1)
                return entry.getKey();
        }
        return 0;
    }
    @Test
    public void test(){
        int[]nums=new int[]{3,4,3,3};
        int mm=singleNumber(nums);
        System.out.println(mm);
    }
}
