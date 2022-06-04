package test;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class 独特的电子邮件地址 {
    public int numUniqueEmails(String[] emails) {
        Set<String>set=new HashSet<>();
        for(int i=0;i<emails.length;i++){
            String cur=emails[i];
            String pre=cur.substring(0,cur.indexOf("@"));
            cur=pre.replace(".","")+cur.substring(cur.indexOf("@"));
            if(cur.contains("+")){
                cur=cur.substring(0,cur.indexOf("+"))+cur.substring(cur.indexOf("@"));
            }
            System.out.println(cur);
            set.add(cur);
        }
        return set.size();
    }
    @Test
    public void test(){
        String[]emails=new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(emails));
    }
}
