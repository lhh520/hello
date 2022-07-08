package 热题100;

public class 地下城游戏 {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        int rowLen = dungeon.length;
        int colLen = dungeon[0].length;
        // 最低的耗血量为 + 1；就是骑士的救公主的最低血量。
        return dfs(0, 0, rowLen, colLen, dungeon) + 1;
    }
    public int dfs (int rowIndex, int colIndex, int rowSize, int colSize, int[][] dungeon){
        if (rowIndex >= rowSize || colIndex >= colSize) {
            return Integer.MAX_VALUE;
        }
        //退出循环的条件
        if(rowIndex==rowSize-1&&colIndex==colSize-1){
            //如果最后的数值大于0 则只需要大于0就可以满足条件
            if(dungeon[rowIndex][colIndex]>=0){
                return 0;
            }else {
                return -dungeon[rowIndex][colIndex];
            }
        }
        int rightMin=dfs(rowIndex,colIndex+1,rowSize,colSize,dungeon);
        int downMin=dfs(rowIndex+1,colIndex,rowSize,colSize,dungeon);
        int needMin=Math.min(rightMin,downMin)-dungeon[rowIndex][colIndex];
        int res=0;
        if(needMin<0){
            res=0;
        }else {
            res=needMin;
        }
        return res;
    }



}
