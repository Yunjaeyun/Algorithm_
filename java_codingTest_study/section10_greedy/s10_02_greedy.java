package java_codingTest_study.section10_greedy;
//25 02 20

import java.util.*;

class Time implements Comparable<Time> {
    int start,end;
    public Time(int s, int e){
        this.start=s;
        this.end=e;
    }
    @Override
    public int compareTo(Time other){
        if(other.end==this.end) return this.start-other.start;
        else return this.end - other.end;
    }

}
public class s10_02_greedy {
    static List<Time> arr;
    static int cnt=0;
    private static void solution(List<Time> arr, int n){
        int end_time = 0;
        arr.sort(null);
        for(Time ob:arr){
            if(ob.start>=end_time){
                end_time=ob.end;
                cnt++;
            }
        }
    }

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        arr = new ArrayList<>();
        for(int i=0; i<n;i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            arr.add(new Time(start, end));
        }
        solution(arr, n);
        System.out.println(cnt);
    }
}
