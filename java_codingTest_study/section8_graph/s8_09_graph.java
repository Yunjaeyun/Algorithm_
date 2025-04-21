package java_codingTest_study.section8_graph;

//25 02 09

import java.util.*;

class Node{
    int data;
    Node lt,rt;

    public Node(int val) {
        data=val;
        lt=rt=null;
    }
}
public class s8_09_graph {
    Node root;
    public int BFS(Node root){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int level=0;
 // py랑 java코드가 다름. java는 그래프 레벨을 보는 코드네!

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i=0; i<len;i++){
                Node cur = q.poll();
                if(cur.lt==null && cur.rt==null) return level; // visited 처리?-> 할필요없음 다른문제임
                if(cur.lt!=null) q.offer(cur.lt);// 인접하는 노드중 자식을 가진 노드가 있으면 다시 탐색해야하므로 추가
                if(cur.rt!=null) q.offer(cur.rt);

            }
            level++;
        }
        return level;
    }



    public static void main(String[]args){
        s8_09_graph tree = new s8_09_graph();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.println(tree.BFS(tree.root));
    }



}
