package java_codingTest_study.section10_greedy.section10_R1;
//25 03 10

import java.util.*;
class Status implements Comparable<Status>{
    int time;
    char status;
    Status(int t, char s){
        this.time=t;
        this.status=s;
    }
    @Override
    public int compareTo(Status other){
        if(this.time==other.time) return this.status-other.status;
        return this.time-other.time;
    }

}
public class s10_03_greedy {
    static List<Status> arr = new ArrayList<>();
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=0;i<n;i++){
            int start_time = sc.nextInt();
            arr.add(new Status(start_time, 's'));

            int end_time = sc.nextInt();
            arr.add(new Status(end_time,'e'));
        }
        sol();
    }
    private static void sol(){
        arr.sort(null);

        int max_people=0;
        int result=Integer.MIN_VALUE;

        for(Status ob:arr){
            if(ob.status=='e') max_people--;
            else max_people++;

            result = Math.max(result, max_people);
        }

        System.out.println(result);

    }
}
