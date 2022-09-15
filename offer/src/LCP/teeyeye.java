package LCP;

public class teeyeye {
    class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
        }

        public Node() {
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    Node dummy,head;
    public Node  Convert(Node pRootOfTree) {
        if(pRootOfTree==null){
            return null;
        }
        dfs(pRootOfTree);
        head.left=dummy;
        dummy.right=head;
        return head;

    }
    public void dfs(Node dummy1){
        if(dummy1==null){
            return;
        }
        dfs(dummy1.left);
        if(dummy!=null){
            dummy.right=dummy1;
        }else {
            head=dummy1;
        }
        dummy1.left=dummy;
        dummy=dummy1;
        dfs(dummy1.right);
    }



}
