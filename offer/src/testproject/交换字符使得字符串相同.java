package testproject;

public class 交换字符使得字符串相同 {
    public int minimumSwap(String s1, String s2) {
        int xy=0,yx=0;
        char[]c1=s1.toCharArray();
        char[]c2= s1.toCharArray();
        for(int i=0;i<c1.length;i++){
            if(c1[i]==c2[i]) continue;
            if(c1[i]=='x') xy++;
            else yx++;
        }
        if((xy+yx)/2!=0) return -1;
        return xy/2+yx/2+(xy%2*2);
    }
}
