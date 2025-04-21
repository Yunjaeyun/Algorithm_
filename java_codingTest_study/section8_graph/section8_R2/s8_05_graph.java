package java_codingTest_study.section8_graph.section8_R2;
//25 03 14

class Node{
    int val;
    Node lt,rt;
    Node(int data){
        val=data;
        lt=rt=null;
    }
}
public class s8_05_graph {
    Node root;
    private static void DFS(Node root){
        if(root==null){
            return;
        }else{
            DFS(root.lt);
            System.out.print(root.val);
            DFS(root.rt);
        }
    }

    public static void main(String[]args){
        s8_05_graph tree = new s8_05_graph();
        tree.root=new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        DFS(tree.root);
    }
}
