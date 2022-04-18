package test;

public class test2087 {

    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
    int a1=startPos[0],a2=startPos[1];
    int b1=homePos[0],b2=homePos[1];
    int sum=0;
    if(a1<b1){//行的代价
        for(int i=a1+1;i<b1;i++){
            sum=sum+rowCosts[i];
        }
    }
    else if(a1>b1){//行的代价
        for(int i=b1;i<a1-1;i++){
            sum=sum+rowCosts[i];
        }
    }
    //
    if(a2<b2){//行的代价
        for(int i=a2+1;i<b2;i++){
            sum=sum+colCosts[i];
        }
    }
    else if(a2>b2){//行的代价
        for(int i=b2;i<a2-1;i++){
            sum=sum+colCosts[i];
        }
    }
    return sum;
    }

}
