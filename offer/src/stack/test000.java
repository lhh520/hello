package stack;

import java.util.ArrayList;
import java.util.Collection;

public class test000 {
    public static void main(String[] args) {
        String a = new String("ab"); // a 为一个引用
        String b = new String("ab"); // b为另一个引用,对象的内容一样
        String aa = "ab"; // 放在常量池中
        String bb = "ab"; // 从常量池中查找
        String bbb=aa+bb;

        String cc=a+bb;
        System.out.println(bbb==cc);
        Collection oo=new ArrayList();

    }
}
