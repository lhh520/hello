package tp101.链表;
import java.util.*;
public class test099999 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String n1=sc.nextLine();
        String nn2=sc.nextLine();
        String[]bb=nn2.split(" ");
        int[]nums=new int[bb.length];
        for(int i=0;i<nums.length;i++){
            nums[i]=Integer.parseInt(bb[i]);
        }

        Map<Integer,Integer>map1=new HashMap<>();
        Map<Integer,Integer>map2=new HashMap<>();

        Set<Integer>set1=new HashSet<>();
        Set<Integer>set2=new HashSet<>();
        List<Integer>list1=new ArrayList<>();
        List<Integer>list2=new ArrayList<>();
        int max1=0,max2=0,ch=-1,ch2=-1;

        if(nums.length==1){
            System.out.println(0);
            return;
        }
        for(int i=0;i< nums.length;i++){
            if(i%2==0){
                map1.put(nums[i],map1.getOrDefault(nums[i],0)+1);
                if(set1.add(nums[i])){
                    list1.add(nums[i]);
                }
                if(map1.get(nums[i])>max1){
                    max1=map1.get(nums[i]);
                    ch=nums[i];
                }

            }else {
                map2.put(nums[i],map2.getOrDefault(nums[i],0)+1);
                if(set2.add(nums[i])){
                    list2.add(nums[i]);
                }
                if(map2.get(nums[i])>=max2){
                    max2=map2.get(nums[i]);
                    ch2=nums[i];
                }
            }
        }

        int ret=0;
        if(ch!=ch2){
            for(int i=0;i< nums.length;i++){
                if(i%2==0){
                    if(nums[i]!=ch){
                        ret++;
                    }
                }else {
                    if(nums[i]!=ch2){
                        ret++;
                    }
                }
            }
        }else {
            Collections.sort(list1, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return map1.get(o2)-map1.get(o1);
                }
            });
            Collections.sort(list2, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return map2.get(o2)-map2.get(o1);
                }
            });
            if(list1.size()==1&&list2.size()==1){
                System.out.println(nums.length/2);
                return;
            }
            if(list1.size()>=2&&list2.size()>=2){
                 int ans1=getnum(nums,list1.get(0),list2.get(1));
                 int ans2=getnum(nums,list1.get(1),list2.get(0));
                System.out.println(Math.min(ans1,ans2));
                return;
            }
            if(list1.size()==1&&list2.size()>=2){
                int ans1=getnum(nums,list1.get(0),list2.get(1));
                System.out.println(ans1);
                return;
            }
            if(list1.size()>1&&list2.size()==1){
                int ans1=getnum(nums,list1.get(1),list2.get(0));
                System.out.println(ans1);
                return;
            }






        }

        System.out.println(ret);
    }
    public static int getnum(int[]nums,int ch,int ch2){
        int ret=0;
        for(int i=0;i< nums.length;i++){
            if(i%2==0){
                if(nums[i]!=ch){
                    ret++;
                }
            }else {
                if(nums[i]!=ch2){
                    ret++;
                }
            }
        }
        return ret;
    }
}
