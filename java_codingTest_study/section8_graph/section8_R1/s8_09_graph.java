package java_codingTest_study.section8_graph.section8_R1;
//25 03 03

import java.util.*;
class Node1{
    int data;
    Node1 lt,rt;
    public Node1(int val){
        this.data=val;
        lt=rt=null;
    }
}
public class s8_09_graph {
    Node1 root;
    private static int BFS(Node1 node){

        Queue<Node1> q = new ArrayDeque<>();

        q.offer(node);
        int L = 0;

        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0;i<len;i++){
                Node1 cur = q.poll();

                if(cur.rt==null && cur.lt==null) return L;
                if(cur.rt!=null) q.offer(cur.rt);
                if(cur.lt!=null) q.offer(cur.lt);

            }
            L++;
        }
        return L;
    }
    public static void main(String[]args){
        s8_09_graph tree = new s8_09_graph();

        tree.root=new Node1(1);
        tree.root.lt = new Node1(2);
        tree.root.rt = new Node1(3);

        tree.root.lt.lt = new Node1(4);
        tree.root.lt.rt = new Node1(5);

        System.out.println(tree.BFS(tree.root));

    }
}
/*
ch배열 어떻게 쓰는지
가장 짧은 길이를 어떻게 구할것인지

☑️ 결국은 1.가장빨리 만나는 2. 말단 경로를 구하는것.
✅ 양쪽둘다 null인지 체크해보면 되겠네

☑️ 인접하는 노드들은 어떻게 다시 넣을것인가
✅ 가장짧은 길이가 아니라면, 뻗어나가야함->왼쪽 오른쪽 자식을 추가
 */