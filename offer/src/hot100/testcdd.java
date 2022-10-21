package hot100;

public class testcdd {
    public int minNumberDisappeared (int[] nums) {
        // write code here
        int[]order=new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            order[nums[i]]++;
        }
        for(int i=1;i<order.length;i++){
            if(order[i]==0){
                return i;
            }
        }
        return 0;
    }
}
