package java_codingTest_study.section8_graph.section8_R2;
//25 03 14

import java.util.*;
public class s8_06_graph {
    static int []ch;
    static int n;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        ch = new int[n + 1];
        DFS(1);
    }
    private static void DFS(int L){
        if(L==n+1){
            for(int i=1;i<=n;i++){
                if(ch[i]==1) System.out.print(i+" ");
            }
            System.out.println();
        }else{
            ch[L]=1;
            DFS(L+1);
            ch[L]=0;
            DFS(L + 1);
        }
    }
}
/*
경우의수 문제네->ox분개 쳐가면서 dfs로 풀면되겠네


        d(1)
       /o  \x
     d(2)
     /ㅇ \x
  d(3)  d(3)
    /
    d(4)

    ch배열에 체크해나가면 될듯

<stack>
    d(2)
    d(1)

    아 첨에 틀렸는데 dfs(L+1)한번더안써서 틀렸네. 이진탐색해야하는데 안햇네. 그래도 답지안보고 고침.
 */