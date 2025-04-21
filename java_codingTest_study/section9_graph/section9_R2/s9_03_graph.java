package java_codingTest_study.section9_graph.section9_R2;
//25 03 16

import java.util.*;
class Problem implements Comparable<Problem>{
    int score, time;
    Problem(int s, int t){
        this.score=s;
        this.time=t;
    }
    @Override
    public int compareTo(Problem other){
        return other.score - this.score;
    }
}
public class s9_03_graph {
    static int n, m;
    static List<Problem> arr = new ArrayList<>();
    static int answer=0;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i=0;i<n;i++){
            int s = sc.nextInt();
            int t = sc.nextInt();
            arr.add(new Problem(s, t));
        }
        arr.sort(null);

        DFS(0, 0, 0);
        System.out.println(answer);
    }
    private static void DFS(int L, int score, int time){
        if(time>m) return;
        if(L==n){
            answer = Math.max(answer, score);
        }else{
            DFS(L + 1, score + arr.get(L).score, time + arr.get(L).time);
            DFS(L + 1, score, time);
        }
    }
}


/*
시간내에 제한조건쓰고. 점수도 +=해야되서, 두개 다써야할듯? class 새로 만들어야할듯
             d(0,0)
             /o 10  x\
            d(1,10,5) d(1,0,0)
 */