package testproject;

import java.util.Arrays;
import java.util.Comparator;

public class main {
    public static void main(String[] args) {
        Integer[] a = {5,3,2,0,1,8,7,6};
//        Comparator cmp = new MyComparator();
        Arrays.sort(a, new MyComparator());
        for (int i = 0; i < a.length; i ++){
            System.out.print(a[i] + " ");
        }
    }
}

class MyComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        if(o1 < o2){
            return 1;
        } else if (o1 > o2) {
            return -1;
        }else{
            return 0;
        }
    }
}
//input: a = {5,3,2,0,1,8,7,6}
//ouput: 8 7 6 5 3 2 1 0



