package test;

public class test832 {
    public int[][] flipAndInvertImage(int[][] image) {
        int len1=image.length,len2=image[0].length;
        for (int i = 0; i <len1; i++)
        {
            for (int j = 0; j <len2/2 ; j++) {
                int temp=image[i][j];
                image[i][j]=image[i][len2-j-1];
                image[i][len2-j-1]=temp;
            }
            for (int j = 0; j <len2 ; j++) {
                image[i][j]=1-image[i][j];
            }
        }
        return image;
    }
}
