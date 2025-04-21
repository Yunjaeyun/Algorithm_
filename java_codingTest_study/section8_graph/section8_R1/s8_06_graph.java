package java_codingTest_study.section8_graph.section8_R1;
//25 03 03

import java.util.*;
public class s8_06_graph {
    static int n;
    static int ch[];
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ch=new int[n+1];

        DFS(1);
    }
    private static void DFS(int L){
        if(L>n){
            for(int i=1;i<=n;i++){
                if(ch[i]==1) System.out.print(i);
            }
            System.out.println();

        }else{
            ch[L]=1;
            DFS(L + 1);
            ch[L]=0;
            DFS(L + 1);
        }
    }
}
/*
        D(0)
      /   |   \
     o1x  o2x  o3x -> 이런사고방식은 방향이 잘못되었지. ___ 한번에 3칸 채울 필요가없잖아?
                                                 한번씩 올라가야지.(왜? bfs가 아닌 dfs니까. 8번문제를 보면 더 이해될듯 뭔말인지)

               D(1)
              o/  \x
            D(2) D(2)
             /      \


사실 이걸풀어보면, s8_05문제가 굉장히 중요한 문제임을 알수있다.
s8_05문제 else문내의 system.out.println는
s8_07문제 check[] 랑 똑같았다.

아이디어는 이전문제를 참조하였으나,
그 이후는 다 내 힘으로 해결하였음.
 */