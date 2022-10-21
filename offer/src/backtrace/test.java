package backtrace;

import org.junit.Test;

import java.util.HashSet;
import java.util.*;
import java.util.regex.Pattern;

public class test {
    public int dateArraysSum (String[] dates) {
        Set<String>set=new HashSet<>();
        Map<String,Integer>map=new HashMap<>();
        map.put("Jan",1);
        map.put("Feb",2);
        map.put("Mar",3);
        map.put("Apr",4);
        map.put("May",5);
        map.put("Jun",6);
        map.put("Jul",7);
        map.put("Aug",8);
        map.put("Seq",9);
        map.put("Oct",10);
        map.put("Nov",11);
        int total=0;
        for(int i=0;i<dates.length;i++){
            if(set.add(dates[i])){
                String[]strings=dates[i].split(" ");
                String d=strings[0];
                int day=0;
                for(int j=0;j<d.length();j++){
                    if(d.charAt(j)>='0'&&d.charAt(j)<='9')
                    day=day*10+d.charAt(j)-'0';
                }
                int month=map.get(strings[1]);

                int year=0;
                for(int j=0;j<strings[2].length();j++){
                    year=year*10+strings[2].charAt(j)-'0';
                }

                int[] amount = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
                if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                    ++amount[1];
                }

                int ans = 0;
                for (int j = 0; j < month - 1; ++j) {
                    ans += amount[j];
                }
                //return ans + day;
                total=total+ans + day;
            }

        }
        return total;

    }
    @Test
    public void test(){
        int i=5;
        do{
            i--;
            System.out.println(i);
        }while (i!=1);
    }




}
