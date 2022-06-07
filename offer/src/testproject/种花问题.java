package testproject;

import java.util.ArrayList;
import java.util.List;

public class 种花问题 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        List<Integer>list=new ArrayList<>();
        int ans=0;
        list.add(0);
        for(int i=0;i<flowerbed.length;i++){
            list.add(flowerbed[i]);
        }
        list.add(0);
        for(int i=0;i<list.size()-2;i++){
            if(list.get(i)==0&&list.get(i+1)==0&&list.get(i+2)==0){
                ans++;
                list.set(i+1,1);
            }
        }
        if(ans>=n){
            return true;
        }else {
            return false;
        }
    }
}
