package java_codingTest_study.section6_스택큐.section6_R2;
//25 04 14

import java.util.*;
class Person{
    int x, danger;
    Person(int x,int danger){
        this.x=x;
        this.danger=danger;
    }
}
public class s6_08 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();


        // while
        // poll()한것보다 , 더 높은 위험값이 있다면, poll()한것을 뒤로 offer
        // 더 높은 위험값이 없다면, 해당 환자 치료
        // 치료한 환자가 m번 환자인가?
        System.out.println(sol(arr, m));

    }

    private static int sol(int[] arr, int m) {
        int cnt=0;


        Queue<Person> q = new ArrayDeque<>();
        int i=0;
        for(int x: arr) {
            q.offer(new Person(i,x));
            i++;
        }

        while(!q.isEmpty()){
            Person cur = q.poll();
            boolean iamMostDanger=true;

            for(Person other:q){
                if(cur.danger < other.danger) {
                    q.offer(cur);
                    iamMostDanger=false;
                    break;
                }

            }

            if(iamMostDanger){
                cnt++;
                if(m==cur.x) return cnt;
            }
        }
        return cnt;
    }
}
