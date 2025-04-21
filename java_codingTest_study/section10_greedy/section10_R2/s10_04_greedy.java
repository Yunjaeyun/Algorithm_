package java_codingTest_study.section10_greedy.section10_R2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

//25 03 24
class Lecture implements Comparable<Lecture>{
    int money, deadline;
    Lecture(int m, int d){
        this.money=m;
        this.deadline=d;
    }
    @Override
    public int compareTo(Lecture other){
        return other.money - this.money;
    }

    @Override
    public String toString(){
        return money+" "+deadline;
    }

}
public class s10_04_greedy {
    public static void main(String[]args){
        List<Lecture> arr = new ArrayList<>();
        PriorityQueue<Lecture> q = new PriorityQueue<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int maxDeadline=0;

        for(int i=0;i<n;i++){
            int m = sc.nextInt();
            int d = sc.nextInt();
            if(d>maxDeadline) maxDeadline=d;
            arr.add(new Lecture(m, d));
        }
        arr.sort((a,b)->b.deadline-a.deadline);

//        System.out.println(arr);
//        System.out.println(maxDeadline);

        int j=0;
        int answer=0;

        for(int i=maxDeadline;i>0;i--){
            while(j<arr.size() && arr.get(j).deadline==i){
                q.offer(arr.get(j));
                j++;
            }
            if(!q.isEmpty()) answer+=q.poll().money;
//            System.out.println(answer);
        }
        System.out.println(answer);
    }
}
/*
60 3
30 3
50 2
30 3
40 2
30 1
20 1

60 3
30 3
50 2
40 2
30 1
20 1

이문제의 핵심은 n일차에 안쓰고 남은거 버리기, 버린거 다음n일차에 재활용해서 여러선택지중 하나에 넣기

20 1
30 1
40 2
50 2
30 3
60 3

3일안에 와야하는거면 1일째에 와도되고 여유많음.
그러나 1일안에 와야하는건, 1일째에 무조권 처리해야함.

20,40,
30+50+60

1일째 -> 30선택 (우선순위큐: 20)
2일째 -> 50선택(우선순위큐:20,40)
3일째-> 60선택(우선순위큐:20,40,30)

논리허점: 40은 1일쨰에도 2일쨰에도 사용할수있다. 2일 안에만 오면되니까.
즉 2일째만 선택되는게 아니다.

20 1
30 1
40 1 2
50 1 2
30 1 2 3
60 1 2 3

거꾸로가는게 맞다.
3일째-> 60 (q 30)
2일째 ->50 (q 30 40)
1일째 ->40

슈도코드
3일째-> q 30 60 poll
2일째-> q 30 40 50 poll


 */