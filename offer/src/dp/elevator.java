package dp;
import java.util.*;
public class elevator {
    private  int cur;//当前的位置
    private  boolean dis;//方向
    private int[]choice;//表示停留的楼层
    private boolean status;
    public class Operate {
         private boolean upDown;
         private int level;

        public boolean isUpDown() {
            return upDown;
        }

        public void setUpDown(boolean upDown) {
            this.upDown = upDown;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }
    }
    List<Operate>list=new ArrayList<>();
    public int getCur() {
        return cur;
    }

    public void setCur(int cur) {
        this.cur = cur;
    }

    public boolean isDis() {
        return dis;
    }

    public void setDis(boolean dis) {
        this.dis = dis;
    }

    public int[] getChoice() {
        return choice;
    }

    public void setChoice(int[] choice) {
        this.choice = choice;
    }
    //处理按键操作，包括方向和地点
    public  void handerRe(boolean upDown,int level){
        //加入任务
        Operate o=new Operate();
        o.setLevel(level);
        o.setUpDown(upDown);
        list.add(o);
    }
    public  void close(){
        status=false;

    }
    public  void open(){

        status=true;
    }

}
