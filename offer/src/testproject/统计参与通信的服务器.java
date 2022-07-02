package testproject;

public class 统计参与通信的服务器 {
    public int countServers(int[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j< grid[0].length;j++){
                if(grid[i][j]==1){
                    boolean flag=false;
                    for(int k=0;k<grid.length;k++){
                        if(k!=i&&grid[k][j]==1){
                            flag=true;
                            count++;
                            break;
                        }
                    }
                    if(!flag){
                        for(int k=0;k<grid[0].length;k++){
                            if(k!=j&&grid[i][k]==1){
                                count++;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
