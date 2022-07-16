package testproject;

import org.junit.Test;

import java.util.*;

public class 子域名访问计数 {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer>map=new HashMap<>();
        for(String str:cpdomains){
            String[]temp=str.split(" ");
            int cur=Integer.parseInt(temp[0]);
            String[]te=temp[1].split("\\.");
            StringBuilder sb=new StringBuilder();
            for(int ii=te.length-1;ii>=0;ii--){
                if(ii!=te.length-1){
                    sb.append(".");
                }
                sb.append(te[ii]);
                map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+cur);
            }
        }
        List<String>list=new ArrayList<>();
        for(Map.Entry<String,Integer>entry: map.entrySet()){
            String[]hh=entry.getKey().split("\\.");
            for (int i = 0; i < hh.length / 2; i++) {
                String temp = hh[i];
                hh[i] = hh[hh.length - 1 - i];
                hh[hh.length - 1 - i] = temp;
            }

            list.add(entry.getValue()+" "+entry.getKey());
        }
        return list;
    }
    @Test
    public void test(){
        String[]strs=new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        System.out.println(strs.length);
        System.out.println(subdomainVisits(strs));

    }
}
