package java_codingTest_study.section10_greedy.section10_R1;
//25 03 10

import java.util.*;
class Time implements Comparable<Time>{
    int s,e;
    Time(int s, int e){
        this.s=s;
        this.e=e;
    }
    @Override
    public int compareTo(Time other){
        if(this.e!=other.e) return this.e-other.e;
        else return this.s-other.s;
    }
}
public class s10_02_greedy {
    static List<Time> arr = new ArrayList<>();
    static int answer=1;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


        for(int i=0;i<n;i++){
            int start = sc.nextInt();
            int end = sc.nextInt();

            arr.add(new Time(start, end));
        }

        sol();
        System.out.println(answer);
    }
    private static void sol(){
        arr.sort(null);
        int end=arr.get(0).e;

        for(Time ob:arr){
            if(end<=ob.s){
                end=ob.e;
                answer++;
            }

        }

    }
}
/*
회의가 빨리 끝나는것부터 넣어야 , 회의를 최대한 사용 가능함.

그럼 먼저 시작하는것부터 넣으면 안되냐?-> 조건(끝나는 시간<=시작시간)을 못맞추게됨
 */
