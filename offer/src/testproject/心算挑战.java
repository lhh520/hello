package testproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 心算挑战 {
    public int maxmiumScore(int[] cards, int cnt) {
        Arrays.sort(cards);
        int len=cards.length;
        List<Integer>odd=new ArrayList<>();
        List<Integer>enev=new ArrayList<>();
        odd.add(0);
        enev.add(0);
        for(int i=len-1;i>=0;i--){
            if(cards[i]%2==1) odd.add(odd.get(odd.size()-1)+cards[i]);
            else enev.add(enev.get(enev.size()-1)+cards[i]);
        }
        int k=0;
        int ans=0;
        while (k<cnt){
            if(k<odd.size()&&(cnt-k)<enev.size()&&(odd.get(k)+enev.get(cnt-k))%2==0){
                ans = Math.max(ans, odd.get(k)+enev.get(cnt-k));
            }
            k+=2;
        }
        return ans;
    }
}
