package test;

public class test860 {
    public boolean lemonadeChange(int[] bills) {
    int[]nums=new int[3];
    for(int i=0;i<bills.length;i++){
        if(bills[i]==5){
            nums[0]++;
        }
        else if(bills[i]==10){
            nums[0]--;
            if(nums[0]<0)
                return false;
            nums[1]++;
        }else {
            if(nums[1]>0){
                nums[1]--;
                if(nums[0]<=0)
                    return false;
                nums[0]--;
                nums[2]++;
            }else{
                if(nums[0]<=2)
                    return false;
                nums[0]=nums[0]-3;
                nums[2]++;
            }
        }
    }
    return true;
    }
}
