package java_codingTest_study.section10_greedy.section10_R1;
//25 03 10

import java.util.*;
class Lecture implements Comparable<Lecture>{
    int money;
    int Dday;
    Lecture(int money, int Dday){
        this.money=money;
        this.Dday=Dday;
    }
    @Override
    public int compareTo(Lecture other){
        return other.Dday-this.Dday;
    }

    @Override
    public String toString(){
        return money+" "+Dday;
    }

}
public class s10_04_greedy {
    static List<Lecture> arr = new ArrayList<>();
    static int max_deadline;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        max_deadline=0;

        for(int i=0;i<n;i++){
            int money = sc.nextInt();
            int Dday = sc.nextInt();

            arr.add(new Lecture(money, Dday));
            if(Dday>max_deadline) max_deadline=Dday;
        }
        arr.sort(null);
//        System.out.println(arr);
        sol();
    }

    private static void sol(){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int sum=0;
        int idx=0;

        for(int day=max_deadline;day>0;day--){ // [60 3, 30 3, 50 2, 40 2, 20 1, 30 1]

            while(idx<arr.size() && day<=arr.get(idx).Dday){
                pq.offer(arr.get(idx).money);
                idx++;
            }
            if(!pq.isEmpty()) sum+=pq.poll();

        }

        System.out.println(sum);

    }
}
