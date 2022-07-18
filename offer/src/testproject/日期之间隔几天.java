package testproject;

import org.junit.Test;

public class 日期之间隔几天 {
    public int daysBetweenDates(String date1, String date2) {

        return Math.abs(getAbs(date1)-getAbs(date2));
    }
    public int getAbs(String date){
        int dayPass[]=new int[]{0,31,59,90,120,151,181,212,243,273,304,334};
        int ans=0;
        String[]d=date.split("-");
        int year=Integer.parseInt(d[0]);
        int month=Integer.parseInt(d[1]);
        int day=Integer.parseInt(d[2]);
        for(int i=1971;i<year;i++){//已经求到了年份
            if((year%400==0)||(year%4==0&&year%100!=0)){
                ans+=366;
            }else {
                ans+=365;
            }
        }
        System.out.println(ans);
        if((year%400==0)||(year%4==0&&year%100!=0)){
            if(month>2){
                ans++;
            }
        }
        ans+=dayPass[month-1];
        ans+=day;
        return ans;
    }
    @Test
    public void test(){
        String date1 ="2020-01-15", date2 =  "2019-12-31";
        System.out.println(daysBetweenDates(date1,date2));
    }
}
