package java_codingTest_study.section9_graph;
//25 02 12
import java.util.*;
public class s9_03_graph {
    static int n,m; //n은 갯수, m은 시간
    static int max_score=-1;
    static int []score, deadline;

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        score = new int[n];
        deadline = new int[n];

        for(int i=0; i<n;i++){
            score[i]=sc.nextInt();
            deadline[i] = sc.nextInt();
        }
        DFS(0,0,0);
        System.out.println(max_score);
    }

    private static void DFS(int L,int sum,int time){
        if(time>m) return;
        if(L==n){
            max_score=Math.max(max_score, sum);
        }else{
            DFS(L + 1, sum + score[L], time + deadline[L]);
            DFS(L + 1, sum, time );

        }
    }
}
