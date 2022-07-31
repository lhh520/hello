package testproject;

import java.util.LinkedList;
import java.util.Queue;

public class 参加会议的最多员工数 {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] du = new int[n];
        for (int i = 0; i < n; i++) {
            du[favorite[i]]++;
        }
        int[] maxLen = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (du[i] == 0){
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()){
            int people = queue.poll();
            du[favorite[people]]--;
            if (du[favorite[people]] == 0){
                queue.offer(favorite[people]);
            }
            maxLen[favorite[people]] = Math.max(maxLen[favorite[people]] , maxLen[people] +1);
        }
        int threemore = 0 , two = 0;
        for (int i = 0; i < n; i++) {
            if (du[i] != 0){
                int love = favorite[i];
                if (favorite[love] == i){
                    two += maxLen[i];
                    two += maxLen[love];
                    two += 2;
                    du[i] = 0;
                    du[love] = 0;
                }else {
                    du[i] = 0;
                    int j = favorite[i];
                    int temp = 1;
                    while (du[j] != 0){
                        du[j] = 0;
                        temp++;
                        j = favorite[j];
                    }
                    threemore = Math.max(threemore , temp);
                }
            }
        }
        return Math.max(threemore,two);
    }
}
