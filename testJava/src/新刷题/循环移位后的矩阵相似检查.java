package 新刷题;

public class 循环移位后的矩阵相似检查 {
    public boolean areSimilar(int[][] mat, int k) {
        boolean flag=true;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]!=mat[i][(j+k)%mat[i].length]){
                    return false;
                }
            }
        }
        return true;
    }
}
