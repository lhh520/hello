package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 大礼包 {
    Map<List<Integer>, Integer> memo = new HashMap<List<Integer>, Integer>();
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        List<List<Integer>>filterSpecial=new ArrayList<>();
        int n=price.size();
        for(List<Integer>sp:special){
            int totalCount=0,totalPrice=0;
            for(int i=0;i<n;i++){
                totalCount+=sp.get(i);//数量
                totalPrice+=sp.get(i)*price.get(i);//购买的价格
            }
            if(totalCount>0&&totalPrice>sp.get(n)){
                filterSpecial.add(sp);
            }
        }
        return dfs(price,special,needs,filterSpecial,n);
    }
    public int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> curNeeds, List<List<Integer>> filterSpecial, int n){
        if(!memo.containsKey(curNeeds)){
            int minoPrice=0;
            for(int i=0;i<n;i++){
                minoPrice+=curNeeds.get(i)*price.get(i);
            }
            for(List<Integer>curSpecial:filterSpecial){
                int specialPrice=curSpecial.get(n);//当前大礼包的价格
                List<Integer>nextNded=new ArrayList<>();//下一个需要的大礼包
                for(int i=0;i<n;i++){
                    if(curSpecial.get(i)>curNeeds.get(i)){
                        break;
                    }
                    nextNded.add(curNeeds.get(i)-curSpecial.get(i));
                }
                if(nextNded.size()==n){
                    minoPrice=Math.min(minoPrice,dfs(price,special,nextNded,filterSpecial,n)+specialPrice);
                }
            }
            memo.put(curNeeds, minoPrice);
        }
        return memo.get(curNeeds);

    }
    @Test
    public void test(){

    }

}
