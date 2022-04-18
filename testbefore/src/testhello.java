import org.junit.Test;

public class testhello {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i;
        for(i=matrix[0].length-1;i>0;i--)
        {
            if(target<matrix[0][i])
                i--;
        }
        for(int j=0;j<matrix.length;j++)
        {
            if(matrix[j][i]==target)
                return true;
        }
        return false;
    }
    //@Test
   /* public void test()
    {
        String matrix = "[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]";
        matrix=matrix.replaceAll("\\[","\\{");
        matrix=matrix.replaceAll("\\]","\\}");
        System.out.println(matrix);

    }*/

    public static void main(String[] args) {
        testhello hh=new testhello();
        System.out.println(8);

    }
}
