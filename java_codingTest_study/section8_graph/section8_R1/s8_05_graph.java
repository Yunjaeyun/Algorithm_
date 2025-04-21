package java_codingTest_study.section8_graph.section8_R1;

//25 03 03

class Node{
    int data;
    Node lt, rt;

    public Node(int val){
        this.data = val;
        lt=rt=null;
    }
}
public class s8_05_graph {
    Node root;
    public void DFS(Node node){
        if(node==null) return;
        else{
            DFS(node.lt);
            System.out.print(node.data + " ");
            DFS(node.rt);
        }
    }

    public static void main(String[]args){
        s8_05_graph tree = new s8_05_graph();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);

        tree.root.rt.rt = new Node(7);
        tree.root.rt.lt = new Node(6);

        tree.DFS(tree.root);
    }
}
/*
스택의 과정을 그려봤더니 막히는 부분이 있었음
몇번째 line인것까지 같이 쓰면 더 잘보임.

  1
 / \
2   3

DFS(2)
DFS(1) 이렇게 저장되고, return하면 DFS(2)가 POP되는 순간이옴.
그러면, -> 이 화살표가 가리키는 line은

->  DFS(node.lt);
    System.out.println(node.data + " ");
    DFS(node.rt);

☑️ 52line과 같다. 여기서 실수하지 말아야할것.
   52line을 실행시키라는것이 아니라, 52로 return된거고, 그 다음인 53 line을 실행한다.

 */