package testproject;

import org.junit.Test;

import java.util.*;

public class 摧毁小行星 {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
       //List<Integer>list=new ArrayList<>();
//       for(int i=0;i<asteroids.length;i++){
//           list.add(asteroids[i]);
//       }
//       Collections.sort(list, new Comparator<Integer>() {
//           @Override
//           public int compare(Integer o1, Integer o2) {
//               return Math.abs(mass-o1)-Math.abs(mass-o2);
//           }
//       });
        Arrays.sort(asteroids);
        long mm=mass;
        for(int i=0;i<asteroids.length;i++){
            if(mm<asteroids[i]){
                return false;
            }
            mm=mm+asteroids[i];
        }

        return true;
    }
    @Test
    public void test(){
        int mass = 10;
        int[]asteroids =new int[]{3,9,19,5,21};
        System.out.println(asteroidsDestroyed(mass,asteroids));
    }
}
