package test;

import java.util.HashMap;

public class test432 {
    public String originalDigits(String s) {
        HashMap<Character,Integer>c=new HashMap<>();
        for (int i = 0; i <s.length(); i++) {
            char cc=s.charAt(i);
            c.put(cc,c.getOrDefault(cc,0)+1);
        }
        int[]cnt=new int[10];
        cnt[0] = c.getOrDefault('z', 0);
        cnt[2] = c.getOrDefault('w', 0);
        cnt[4] = c.getOrDefault('u', 0);
        cnt[6] = c.getOrDefault('x', 0);
        cnt[8] = c.getOrDefault('g', 0);

        cnt[3] = c.getOrDefault('h', 0) - cnt[8];
        cnt[5] = c.getOrDefault('f', 0) - cnt[4];
        cnt[7] = c.getOrDefault('s', 0) - cnt[6];

        cnt[1] = c.getOrDefault('o', 0) - cnt[0] - cnt[2] - cnt[4];

        cnt[9] = c.getOrDefault('i', 0) - cnt[5] - cnt[6] - cnt[8];
        StringBuilder  sb=new StringBuilder();
        for (int i = 0; i <10; i++) {
            for(int j=0;j<cnt[i];j++)
            {
                sb.append((char)(i+'0'));
            }
        }
        return sb.toString();
    }
}
