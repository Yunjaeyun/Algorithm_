package java_codingTest_study.section10_greedy;
//2025 02 20 Main

import java.util.*;

class Time3 implements Comparable<Time3>{
    int time;
    char state;
    Time3(int time, char state){
        this.time=time;
        this.state=state;
    }
    @Override
    public int compareTo(Time3 other){
        if(this.time==other.time) return this.state-other.state;
        else return this.time-other.time;
    }
}
public class s10_03_greedy {
    static List<Time3> arr;
    static int cnt=0, answer=0;

    private static void solution(List<Time3> arr, int n){
        arr.sort(null);
        for(Time3 ob:arr){
            if(ob.state=='s') cnt++;
            else cnt--;

            answer=Math.max(answer, cnt);

        }
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            int sT=sc.nextInt();
            int eT=sc.nextInt();
            arr.add(new Time3(sT,'s'));
            arr.add(new Time3(eT,'e'));
        }

        solution(arr,n);
        System.out.println(answer);
    }
}
