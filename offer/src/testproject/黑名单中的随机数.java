package testproject;

import java.util.*;

public class 黑名单中的随机数 {
    Random random;
    Map<Integer,Integer>map;
    public 黑名单中的随机数(int n, int[] blacklist) {
        //映射的map
        random=new Random();
        map=new HashMap<>();
        Set<Integer>set=new HashSet<>();
        for(int i=0;i< blacklist.length;i++){
            set.add(blacklist[i]);//建立黑名单
        }
        //建立映射
        int acount=0;
        for(int i=0;i<n;i++){
            if(set.contains(i)){//如果包含怎么样
                continue;
            }else {
                map.put(acount++,i);//表示不在黑名单中
            }
        }
    }

    public int pick() {
        int x=random.nextInt(map.size());
        return map.get(x);
    }
}
