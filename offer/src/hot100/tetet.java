package hot100;

import org.junit.Test;

public class tetet {
    //4,4,2,3,[0,1,1,2,3,4,0]
    int[][]move=new int[][]{{0,0},{-1,0},{0,1},{1,0},{0,-1}};
    public int[] GetLocation (int m, int n, int x, int y, int[] dirs) {
        System.out.println(1);
        for(int i=0;i<dirs.length;i++){
            int[]temp=move[dirs[i]];
            int nx=x+temp[0];
            int ny=y+temp[1];
            if(nx>=0&&nx<m&&ny>=0&&ny<n){
                x=nx;
                y=ny;
            }


//            if(nx<0||nx>=m||ny<0||ny>=n) {
//                nx=x;
//                ny=y;
//            }
//            x=nx;
//            y=ny;
            System.out.println(x+" "+y);
        }
        return new int[]{x,y};
    }
    @Test
    public void test(){
        int[]nums=new int[]{0,1,1,2,3,4,0};
        System.out.println(GetLocation(4,4,2,3,nums));
    }


}
