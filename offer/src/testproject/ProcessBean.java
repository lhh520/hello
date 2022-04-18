package testproject;

public class ProcessBean {
    //用户标识ID
    private String uid;
    //进程ID
    private Integer pid;
    //父进程ID
    private Integer  ppid;
    //CPU利用率
    private Integer c;
    //进程开始时间
    private String stime;
    //终端设备
    private String tty;
    //运行总时间
    private String time;
    //完整命令名
    private String cmd;

    public ProcessBean(String uid, Integer pid, Integer ppid, Integer c, String stime, String tty, String time, String cmd) {
        this.uid = uid;
        this.pid = pid;
        this.ppid = ppid;
        this.c = c;
        this.stime = stime;
        this.tty = tty;
        this.time = time;
        this.cmd = cmd;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getPpid() {
        return ppid;
    }

    public void setPpid(Integer ppid) {
        this.ppid = ppid;
    }

    public Integer getC() {
        return c;
    }

    public void setC(Integer c) {
        this.c = c;
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    public String getTty() {
        return tty;
    }

    public void setTty(String tty) {
        this.tty = tty;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    @Override
    public String toString() {
        return "ProcessBean{" +
                "uid='" + uid + '\'' +
                ", pid=" + pid +
                ", ppid=" + ppid +
                ", c=" + c +
                ", stime='" + stime + '\'' +
                ", tty='" + tty + '\'' +
                ", time='" + time + '\'' +
                ", cmd='" + cmd + '\'' +
                '}';
    }
}
