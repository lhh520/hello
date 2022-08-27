package tp101.链表;

import java.util.*;
public class test03 {
    static int n = 0;
    static int edges = 0;
    static int graph[][];
    static int visit[];
    //存放到当前顶点的最短路径
    static int d[];
    public static void main(String[] args) {
        //首先需要构建出图
        Scanner sc = new Scanner(System.in);

        String nn=sc.nextLine();
        String mm[]=nn.split(" ");

        n=Integer.parseInt(mm[0]);
        graph = new int[n][n];


        visit = new int[n];
        d = new int[n];
        edges=Integer.parseInt(mm[1]);

        for(int i=0;i<3;i++){
            String nnn=sc.nextLine();
            String mmm[]=nnn.split(" ");
            for(int j=0;j<edges;j++){
                int start = i;
                int end=j;
                int weight = Integer.parseInt(mmm[j]);
                graph[start][end] = weight;
                //graph[end][start] = weight;
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int dis = prim(i);
            min=Math.min(dis,min);
        }

        System.out.println(min);

    }

    private static int prim(int u) {
        //一开始的时候存放源点到其他顶点的最短路径设置为Integer.MAX
        Arrays.fill(d, Integer.MAX_VALUE);
        d[u] = 0;
        //存放最小生成树的边权之和
        int ans = 0;
        for(int i = 0; i < n; i++){
            u = -1;
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < n; j++){
                //因为一开始的时候设置了源点到自己的路径为0
                //min表示的是最小的边
                if(visit[j] == 0 && d[j] < min){
                    u = j;
                    min = d[j];
                }
            }
            if(u == -1) return -1;
            visit[u] = 1;
            ans += d[u];
            for(int v = 0; v < n; v++){
                if(visit[v] == 0 && graph[u][v] != 0 && graph[u][v] < d[v]){
                    d[v] = graph[u][v];
                }
            }
        }
        //System.out.println(ans);
        return ans;
    }
}
