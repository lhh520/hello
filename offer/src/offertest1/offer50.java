package offertest1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class offer50 {

    public char firstUniqChar(String s) {
        HashMap<Character,Integer>map=new HashMap<>();
        char[]chars=s.toCharArray();
        int n=1;
        for(int i=0;i<chars.length;i++){
            map.put(chars[i],map.getOrDefault(chars[i],0)+1);

        }
        for(int i=0;i<chars.length;i++){
            if(map.get(chars[i])==1){
                return chars[i];
            }
        }
        return 'a';
    }
}
