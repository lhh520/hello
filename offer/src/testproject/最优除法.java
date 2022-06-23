package testproject;

import org.junit.Test;

public class 最优除法 {
    public String optimalDivision(int[] nums) {//后面出现的值应该尽量的小，数组中每个元素都大于2
        StringBuilder sb=new StringBuilder();
        if(nums.length==1){
            sb.append(nums[0]);
            return sb.toString();
        }
        for(int i=0;i< nums.length;i++){
            if(i==0){
                sb.append(nums[i]);
                if(nums.length>2)
                sb.append("/(");else {
                    sb.append("/");
                }
                continue;
            }else {
                sb.append(nums[i]);
                sb.append("/");
            }

        }
        sb.deleteCharAt(sb.length()-1);
        if(nums.length>2)
        sb.append(')');
        return sb.toString();
    }
    @Test
    public void test(){
        int[]nums=new int[]{3,2};
        System.out.println(optimalDivision(nums));
    }
}
