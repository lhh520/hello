package offertest1;

import java.util.*;

public class offer115 {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {

        int nodeCnt = org.length;

        // 由于org是全排列，因此可以直接用数组记录节点的入度
        int[] node2incnt = new int[nodeCnt+1];

        // 记录节点是否出现过，如果有一个节点不存在，肯定无法重建序列
        boolean[] exist = new boolean[nodeCnt+1];
        List<Set<Integer>> graph = new ArrayList<>(nodeCnt);

        // 预先准备好资源，避免繁杂的null判断
        for(int i = 0; i <= nodeCnt; i++) {
            graph.add(new HashSet<>());
        }

        for(List<Integer> seq: seqs) {
            int lastNode = seq.get(0);//出发点

            for(int i = 0; i < seq.size(); i++) {
                int curNode = seq.get(i);//当前值

                // 如果出现非org里的节点，也不可能重建org，小于0和大于最大值都是不可能重建的
                if(curNode <= 0 || curNode > nodeCnt) return false;
                exist[curNode] = true;//表示确实存在这一节点

                // 除了第一个节点只有出没有入之外，都得增加入度，表示从第一个节点可以到达其他的节点
                if(i>0 && graph.get(lastNode).add(curNode)){
                    node2incnt[curNode]++;
                }

                lastNode = curNode;
            }
        }

        Queue<Integer> bfs = new LinkedList<>();
        for(int i = 1; i <= nodeCnt; i++) {
            if(exist[i]==false) return false;
            if(node2incnt[i]==0) bfs.offer(i);
        }

        int sameCnt = 0;
        while(!bfs.isEmpty()) {
            int size = bfs.size();
            // 判断是否唯一序列
            if(size > 1) return false;
            while(size-- > 0) {
                int curNode = bfs.poll();
                // 判断序列是否匹配
                if(curNode != org[sameCnt++]) return false;
                for(int nxtNode: graph.get(curNode)) {
                    node2incnt[nxtNode]--;
                    if(node2incnt[nxtNode]==0)
                        bfs.offer(nxtNode);
                }
            }
        }
        return sameCnt == nodeCnt;

    }

}
