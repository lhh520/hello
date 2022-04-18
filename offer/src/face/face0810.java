package face;

import java.util.LinkedList;
import java.util.Queue;

public class face0810 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor)
        return image;
        int[]dx={1,0,-1,0};
        int[]dy={0,1,0,-1};
        int n=image.length;
        int m=image[0].length;
        Queue<int[]>queue=new LinkedList<>();
        queue.add(new int[]{sr,sc});
        while (!queue.isEmpty())
        {
            int[]temp=queue.poll();
            int x=temp[0],y=temp[1];
            for(int i=0;i<4;i++)
            {
                int mx=x+dx[i];
                int my=y+dy[i];
                if(mx>=0&&mx<n&&my>=0&&my<m&&image[mx][my]==image[sr][sc])
                {
                 queue.add(new int[]{mx,my});
                    image[mx][my]=newColor;
                }
            }
        }
        image[sr][sc]=newColor;
        return image;
    }
}
