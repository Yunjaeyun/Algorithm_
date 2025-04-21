package java_codingTest_study.section10_greedy.section10_R2;
//25 03 24

import java.util.*;
class Info implements Comparable<Info>{
    int time;
    char status;
    Info(int t, char s){
        this.time =t;
        this.status =s;
    }

    @Override
    public int compareTo(Info other){
        if(this.time==other.time) return this.status-other.status;
        else return this.time-other.time;
    }
}
public class s10_03_greedy {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Info> arr = new ArrayList<>();

        for(int i=0;i<n;i++){
            int start_time = sc.nextInt();
            arr.add(new Info(start_time, 's'));

            int end_time = sc.nextInt();
            arr.add(new Info(end_time, 'e'));

        }

        arr.sort(null);
        int answer=0;
        int result=0;

        for(Info cur:arr){
            if(cur.status=='s') answer++;
            else answer--;
            result = Math.max(result, answer);
        }
        System.out.println(result);


    }
}
/*
핵심은 "동시에" 존재

         14        18
    12      15
            15            20
                          20       30
 5       14

들어오는순으로
5 14
12 15
14 18
15 20
20 30

5 s  1
12 s 2
14 e 1
14 s 2
15 e 1
15 s 2
18 e 1


  */