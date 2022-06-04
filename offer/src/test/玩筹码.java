package test;

public class 玩筹码 {
    public int minCostToMoveChips(int[] position) {
        int odd=0;
        int env=0;
        for(int i=0;i<position.length;i++){
            if(position[i]%2==0){
                odd++;
            }else {
                env++;
            }
        }
        return Math.min(odd,env);
    }
}
