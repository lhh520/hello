package test;

public class test836 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if(rec1[0]>rec2[0]&&rec1[0]<rec2[2]&&rec1[1]<rec2[1]&&rec1[1]>rec2[3])
            return true;
        if(rec1[2]>rec2[0]&&rec1[2]<rec2[2]&&rec1[3]<rec2[1]&&rec1[3]>rec2[3])
            return true;
        return false;
    }
    public boolean isRectangleOverlap1(int[] rec1, int[] rec2) {
        return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]) &&
                Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));
    }
}
