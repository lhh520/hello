package test;

public class 骑士在棋盘上的概率 {
    public double knightProbability(int n, int k, int row, int column) {
        int[][] dir = new int[][]{{-1,-2},{-1,2},{1,-2},{1,2},{-2,1},{-2,-1},{2,1},{2,-1}};
        double[][][]pro=new double[k][row][column];
        for(int step=0;step<=k;step++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(step==0){
                        pro[step][i][j]=1;//0步之内必然在棋盘上
                    }else {
                        for(int[]p:dir){
                            int ni=i+p[0];
                            int nj=j+p[1];
                            if(ni>=0&&ni<n&&nj>=0&&nj<n){
                                pro[step][i][j]=pro[step][i][j]+pro[step-1][ni][nj]/8;
                            }
                        }
                    }
                }
            }
        }
        return pro[k][row][column];
    }
}
