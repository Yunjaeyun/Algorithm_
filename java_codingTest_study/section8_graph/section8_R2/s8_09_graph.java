package java_codingTest_study.section8_graph.section8_R2;
//25 03 14

import java.util.*;
class Node1{
    int data;
    Node1 lt, rt;
    Node1(int val){
        this.data=val;
        lt = rt = null;
    }
}
public class s8_09_graph {

    Node1 root;
    static int L=0;

    private static int BFS(Node1 root){
        Queue<Node1> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0;i<len;i++){
                Node1 cur = q.poll();

                if(cur.lt==null && cur.rt==null) return L;
                if(cur.lt!=null) q.offer(cur.lt);
                if(cur.rt!=null) q.offer(cur.rt);

            }
            L++;
        }
        return L;
    }
    public static void main(String[]args){
        s8_09_graph tree = new s8_09_graph();
        tree.root = new Node1(1);
        tree.root.lt = new Node1(2);
        tree.root.lt.lt = new Node1(4);
        tree.root.lt.rt = new Node1(5);
        tree.root.rt = new Node1(3);
        System.out.println(BFS(tree.root));

    }
}
// cur을 root로 쓴 실수