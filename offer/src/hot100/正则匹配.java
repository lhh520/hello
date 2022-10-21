package hot100;

import java.util.*;

public class 正则匹配 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str1=sc.nextLine();
        String str2=sc.nextLine();
        int mm=str1.length();
        int nn=str2.length();
        boolean[][]mat=new boolean[mm+1][nn+1];
        mat[0][0]=true;
        for(int i=0;i<=mm;i++){
            for(int j=1;j<=nn;j++){
                if(str2.charAt(j-1)=='*'){
                    mat[i][j]=mat[i][j-2];
                    if(getmat(str1,str2,i,j-1)){
                        mat[i][j]=mat[i][j]||mat[i-1][j];
                    }
                }else {
                    if(getmat(str1,str2,i,j)){
                        mat[i][j]=mat[i-1][j-1];
                    }
                }
            }
        }
        System.out.println(mat[mm][nn]);
    }
    public static boolean getmat(String first,String second,int i,int j){
        if(i==0){
            return false;
        }
        if(second.charAt(j-1)=='.'){
            return true;
        }
        return first.charAt(i-1)==second.charAt(j-1);
    }
}
