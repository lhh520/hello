package test;

public class 逃脱阻碍者 {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int[] source=new int[]{0,0};
        int dis=distance(source,target);//求得小终点的距离
        for(int[]gost:ghosts){
            int gdis=distance(gost,target);
            if(gdis<dis){
                return false;
            }
        }
        return true;
    }
    public int distance(int[]p1,int[]p2){
        return Math.abs(p1[0]-p2[0])+Math.abs(p1[1]-p2[1]);
    }
}
