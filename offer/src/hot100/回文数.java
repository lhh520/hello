package hot100;

import java.util.*;

public class 回文数 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        int left=0,right=str.length()-1;
        while (left<right){
            if(str.charAt(left)!=str.charAt(right)){
                System.out.println(false);
                return;
            }else {
                left++;
                right--;
            }
        }
        System.out.println(true);
    }

}
