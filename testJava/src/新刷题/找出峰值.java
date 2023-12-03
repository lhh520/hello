package 新刷题;

import java.util.ArrayList;
import java.util.List;

public class 找出峰值 {
    public List<Integer> findPeaks(int[] mountain) {
        if(mountain.length<=2){
            return new ArrayList<>();
        }
        List<Integer>ans=new ArrayList<>();
        for(int i=1;i<mountain.length-1;i++){
            int befo=mountain[i-1];
            int after=mountain[i+1];
            if(mountain[i]>befo&&mountain[i]>after){
                ans.add(i);
            }
        }
        return ans;
    }
}
