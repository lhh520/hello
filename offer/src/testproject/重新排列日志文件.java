package testproject;

import org.junit.Test;

import java.util.*;

public class 重新排列日志文件 {
    public String[] reorderLogFiles(String[] logs) {
        int sumlet=0;
        for(int i=0;i<logs.length;i++){

            if(logs[i].startsWith("let")){
                sumlet++;
            }
        }
        String[]log2=new String[logs.length];
        List<String>log3=new ArrayList<>();
        int m=0,n=sumlet;
        for(int i=0;i<logs.length;i++){
            char c=logs[i].charAt(logs[i].length()-1);
            if(c>='0'&&c<='9'){
                log2[n]=logs[i];
                n++;
            }else {
                log2[m]=logs[i];
                log3.add(logs[i]);
                m++;
            }
        }
        Collections.sort(log3, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                return 0;
            }
        });



        return log2;
    }
    @Test
    public void test(){
        String[] ans=new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        String[]rr=reorderLogFiles(ans);
        System.out.println(Arrays.toString(rr));
    }
}
