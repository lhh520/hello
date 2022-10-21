package test2022;

import org.junit.Test;

import java.util.Arrays;

public class ee {
    public void merge(int A[], int m, int B[], int n){
        int i=0,j=0,k=0;
        int[]nums2=new int[m];
        while (i<m-n||j<n){
            int a=i>=m-n?Integer.MAX_VALUE:A[i];
            int b=j>=n?Integer.MAX_VALUE:B[j];
            if(a>b){
                nums2[k++]=B[j++];
            }else{
                nums2[k++]=A[i++];
            }
        }
        A=nums2;
    }
    @Test
    public void test(){
        int[]A=new int[]{1,2,6,0,0,0};
        int[]B=new int[]{2,3,5};
        merge(A,6,B,3);
    }
}
