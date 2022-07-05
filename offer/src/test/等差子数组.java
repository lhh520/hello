package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 等差子数组 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean>flag=new ArrayList<>();
        boolean f;
        for(int i=0;i<l.length;i++){
            int left=l[i];
            int right=r[i];
            f=false;
            int[] temp=Arrays.copyOfRange(nums,left,right+1);
            Arrays.sort(temp);
            //先求公差
            int c=(temp[temp.length-1]-temp[0])/(temp.length-1);
            for(int j=1;j<temp.length;j++){
                if(temp[j]-temp[j-1]!=c){
                    f=false;
                    flag.add(f);
                    break;
                }
            }
            if(f){
                flag.add(true);
            }
        }
        return flag;
    }
}
