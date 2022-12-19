package nums;

import java.util.*;
class GFG
{


    static class AdjListNode {
        int v;
        int weight;

        AdjListNode(int _v, int _w)
        {
            v = _v;
            weight = _w;
        }
        int getV() { return v; }
        int getWeight() { return weight; }
    }

    static class Graph {
        int V; // No. of vertices'


        ArrayList<ArrayList<AdjListNode>> adj;
        ArrayList<ArrayList<Integer>> path;
        Graph(int V) // Constructor
        {
            this.V = V;
            adj = new ArrayList<ArrayList<AdjListNode>>(V);
            path=new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<AdjListNode>());
                path.add(new ArrayList<>());
            }
        }

        void addEdge(int u, int v, int weight)
        {
            AdjListNode node = new AdjListNode(v, weight);
            adj.get(u).add(node); // Add v to u's list
        }


        void topologicalSortUtil(int v, boolean visited[],
                                 Stack<Integer> stack)
        {

            visited[v] = true;


            for (int i = 0; i<adj.get(v).size(); i++) {
                AdjListNode node = adj.get(v).get(i);
                if (!visited[node.getV()])
                    topologicalSortUtil(node.getV(), visited, stack);
            }


            stack.push(v);
        }


        void longestPath(int s)
        {
            Stack<Integer> stack = new Stack<Integer>();
            int dist[] = new int[V];


            boolean visited[] = new boolean[V];
            for (int i = 0; i < V; i++)
                visited[i] = false;

            for (int i = 0; i < V; i++)
                if (visited[i] == false)
                    topologicalSortUtil(i, visited, stack);


            for (int i = 0; i < V; i++)
                dist[i] = Integer.MIN_VALUE;

            dist[s] = 0;

            path.get(s).add(s);
            while (stack.isEmpty() == false)
            {


                int u = stack.peek();
                stack.pop();


                if (dist[u] != Integer.MIN_VALUE)
                {
                    for (int i = 0; i<adj.get(u).size(); i++)
                    {
                        AdjListNode node = adj.get(u).get(i);
                        if (dist[node.getV()] < dist[u] + node.getWeight()){
                            dist[node.getV()] = dist[u] + node.getWeight();
                            path.get(node.getV()).add(node.getV());

                        }

                    }
                }
            }


            for (int i = 0; i < V; i++)
                if(dist[i] == Integer.MIN_VALUE)
                    System.out.print("INF ");
                else{
                    System.out.println(dist[i]);
                    //System.out.println(path.get(i));
                }

        }
    }


    public static void main(String args[])
    {

        Graph g = new Graph(12);
        g.addEdge(0, 1, 1);

        g.addEdge(0, 4, 3);

        g.addEdge(1, 2, 2);

        g.addEdge(1, 5, 5);

        g.addEdge(2, 3, 4);

        g.addEdge(2, 6, 1);



        g.addEdge(3, 7, 2);



        g.addEdge(4, 5, 5);

        g.addEdge(4, 8, 1);

        g.addEdge(5, 6, 1);

        g.addEdge(5, 9, 1);

        g.addEdge(6, 7, 2);

        g.addEdge(6, 10, 3);



        g.addEdge(7, 11, 2);



        g.addEdge(8, 9, 1);



        g.addEdge(9, 10, 3);



        g.addEdge(10, 11, 2);



        int s = 0;

        g.longestPath(s);

    }
}
