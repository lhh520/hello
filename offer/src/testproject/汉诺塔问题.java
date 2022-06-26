package testproject;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class 汉诺塔问题 {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        for(int i=0;i<A.size();i++){
             C.add(A.get(i));
        }
    }
}
