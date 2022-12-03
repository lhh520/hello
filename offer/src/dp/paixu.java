package dp;
//化妆品导购:51,奶茶店员:70,医药连锁:27,夜班8小时店员:38,店员:97,促销:108,珠宝导购:16,天街招聘:8,店员营业员:112,督导:25
import java.util.*;

public class paixu {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[]strs=str.split(",");
        List<String>list=new ArrayList<>();
        for(int i=0;i<strs.length;i++){
            list.add(strs[i]);
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[]c1=o1.split(":");
                String[]c2=o2.split(":");
                return Integer.parseInt(c2[1])-Integer.parseInt(c1[1]);
            }
        });
        for(int i=0;i<5;i++){
            System.out.println(list.get(i));
        }
    }
}
