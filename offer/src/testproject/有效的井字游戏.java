package testproject;

public class 有效的井字游戏 {
    public boolean validTicTacToe(String[] board) {
        char[][]cs=new char[3][3];
        int x=0,o=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                char c=board[i].charAt(j);
                if(c=='X') x++;
                if(c=='O') o++;
                cs[i][j]=c;
            }
        }
        boolean a=check(cs,'X'),b=check(cs,'O');//各自判定是不是胜利的
        if(o>x||x-o>1) return false;//因为x先手 所以x必然不会小于o
        if(a&&x<=o) return false;
        if(b&&o!=x) return false;
        if(a&&b) return false;
        return true;
    }
    //判定是谁赢了
    boolean check(char[][]cs,char c){
        for(int i=0;i<3;i++){//不存在横着或者竖着赢得可能性
            if (cs[i][0] == c && cs[i][1] == c && cs[i][2] == c) return true;
            if (cs[0][i] == c && cs[1][i] == c && cs[2][i] == c) return true;
        }
        boolean a=true,b=true;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                //判定两条对角线是否正确
                if(i==j) a&=cs[i][j]==c;
                if(i+j==2) b&=cs[i][j]==c;
            }
        }
        return a||b;
    }
}
