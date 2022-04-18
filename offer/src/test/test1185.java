package test;

public class test1185 {
    public String dayOfTheWeek(int day, int month, int year) {
        //总体思路，得到当前的星期距离最初的天数，然后进行计算
        String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        //输入年份
        int days=365*(year-1971)+(year-1969)/4;
        //输入年份中，输入月份之前的月份的天数
        for(int i=0;i<month-1;i++)
        {
            days+=monthDays[i];
        }
        if(((year%4==0&&year%100!=0)||year%400==0)&&month>=3)
            days+=1;
        //输入天数的贡献
        days+=day;
        return week[(days+3)%7];
    }
}
