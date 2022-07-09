package 热题100;

import org.junit.Test;

public class 统计星号 {
    public int countAsterisks(String s) {
        int nn=0;
        int count=0;
        for(int i=0;i<s.length();i++) {
          if(nn==0&&s.charAt(i)=='*'){
              count++;
          }
          if(s.charAt(i)=='|'){
              if(nn==0){
                  nn=1;
              }else {
                  nn=0;
              }
          }
        }
        return count;
    }
    @Test
    public void test(){
        String s="l|*e*et|c**o|*de|";
        System.out.println(countAsterisks(s));
    }
}
