package testproject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 判断路径是否相交 {
    public boolean isPathCrossing(String path) {
        char[]chars=path.toCharArray();
        Set<Integer>set=new HashSet<>();
        int x=0,y=0;
        set.add(getHash(x,y));
        int length=path.length();
        for(int i=0;i<chars.length;i++){
            char c=chars[i];
            switch (c){
                case 'N':x--;break;
                case 'S':x++;break;
                case 'W':y--;break;
                case 'E':y++;break;
            }
            if(set.contains(getHash(x,y))){
                return true;
            }
            set.add(getHash(x,y));
        }
        return false;
    }
    public int getHash(int x,int y){
        return x*200001+y;
    }
}
