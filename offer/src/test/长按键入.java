package test;

import org.junit.Test;

public class 长按键入 {
    //输入：name = "alex", typed = "aaleex"
    //输出：true
    //解释：'alex' 中的 'a' 和 'e' 被长按。
    public boolean isLongPressedName(String name, String typed) {
        //双指针
        int i=0,j=0;
        while (i<name.length()&&j<typed.length()){
            if (typed.charAt(j)==name.charAt(i)){//确实相等的数字
                j++;
                i++;
            }
            else {
                if(j>0&&typed.charAt(j)!=typed.charAt(j-1)){
                    return false;
                }
                j++;
            }
        }
        while (j<typed.length()){
            if(j>0&&typed.charAt(j)!=typed.charAt(j-1)){
                return false;
            }
            j++;
        }
        if(i==name.length()){
            return true;
        }
        return false;
    }
    @Test
    public void test(){
        String name = "a", typed ="b";
        System.out.println(isLongPressedName(name,typed));
    }
}
