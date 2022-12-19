package nums;
import org.junit.Test;

import java.util.*;
public class Solution01 {
int NINF =Integer.MIN_VALUE;

    class AdjListNode {

        int v;

        int weight;



        public AdjListNode(int _v, int _w) {

            v = _v;

            weight = _w;

        }

        int getV() { return v; }

        int getWeight() { return weight; }

    };





    class Graph {

        int V;
        List<AdjListNode>adj;
        List<Integer>pPath;
        public Graph(int V){
            this.V = V;
            adj =new ArrayList<>();
            pPath = new ArrayList<>();
        }
        void addEdge(int u, int v, int weight) {
            AdjListNode node=new AdjListNode(v,weight);

            adj.set(u,node);
        };
        void topologicalSortUtil(int v, boolean visited[], Stack<Integer>stack) {


            visited[v] = true;

            for(int i=0;i<adj.size();i++){
                AdjListNode node = adj.get(i);
                if(!visited[node.getV()]){
                    topologicalSortUtil(node.getV(), visited, stack);
                }

            }
            stack.push(v);
        }


        void longestPath(int s) {

            Stack<Integer> stack=new Stack<>();

            //int * dist = new int[V];
            int[]dist=new int[V];

            boolean[]visited=new boolean[V];
            // Mark all the vertices as not visited



            for (int i = 0; i < V; i++)

                visited[i] = false;




            for (int i = 0; i < V; i++)
                if (visited[i] == false)
                    topologicalSortUtil(i, visited, stack);




            for (int i = 0; i < V; i++) {

                pPath.set(s,null);

                dist[i] = NINF;

            }



            dist[s] = 0;


            pPath.set(s,s);



            while (stack.empty() == false) {

                int u = stack.peek();

                stack.pop();


                if (dist[u] != NINF) {

                    for (int i =0; i != adj.size(); ++i) {
                        AdjListNode node= adj.get(i);

                        if (dist[node.getV()] < dist[u] + node.getWeight()) {

                            //更新与u相连的各个顶点到s的距离

                            dist[node.getV()] = dist[u] +node.getWeight();

                            //更新具体路径

                            pPath.set(node.getV(),node.getV());

                        }

                    }

                }

            }

            for (int i = 0; i < V; i++) {


                System.out.println("length: ");
                if(dist[i] == NINF) {
                    System.out.println("unReachable");

                }else {
                    System.out.println(dist[i]);

                }
                System.out.println();
                System.out.println("path: ");
                for (int j=0;j<pPath.size();j++) {
                    System.out.println(pPath.get(j));
                }
                System.out.println();
            }

        }


        }
    @Test
    public  void test() {
        Graph g=new Graph(12);

        g.addEdge(0, 1, 1);

        g.addEdge(0, 4, 3);

        g.addEdge(1, 2, 2);

        g.addEdge(1, 5, 5);

        g.addEdge(2, 3, 4);

        g.addEdge(2, 6, 1);

        //g.addEdge(3, 4, 0);//3号顶点处于棋盘最右

        g.addEdge(3, 7, 2);



        g.addEdge(4, 5, 5);

        g.addEdge(4, 8, 1);

        g.addEdge(5, 6, 1);

        g.addEdge(5, 9, 1);

        g.addEdge(6, 7, 2);

        g.addEdge(6, 10, 3);



        g.addEdge(7, 11, 2);



        g.addEdge(8, 9, 1);

        //g.addEdge(8, 8, 1);

        g.addEdge(9, 10, 3);

        //g.addEdge(9, 9, 1);

        g.addEdge(10, 11, 2);
        int s = 0;
        g.longestPath(s);

    }

}
