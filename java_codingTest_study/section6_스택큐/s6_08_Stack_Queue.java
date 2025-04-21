package java_codingTest_study.section6_스택큐;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// 25 01 21

class Person{
    int id;
    int priority;

    public Person(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}
public class s6_08_Stack_Queue {
    private int sol(int n, int m, int[] arr){
        Queue<Person> q=new LinkedList<>();
        int answer=0;
        for(int i=0; i<n;i++) q.offer(new Person(i,arr[i]));

        while(!q.isEmpty()){
            Person tmp=q.poll();
            for(Person x:q){
                if(tmp.priority < x.priority){
                    q.offer(tmp);
                    tmp=null;
                    break;
                }
            }
            if(tmp!=null) {
                answer+=1;
                if(tmp.id==m) return answer;

            }
        }
        return answer;
    }

    public static void main(String[] args) {
        s6_08_Stack_Queue t=new s6_08_Stack_Queue();
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        int[] arr = new int[n];
        for(int i=0;i<n;i++)  arr[i]=sc.nextInt();
        System.out.println(t.sol(n,m,arr));

    }
}
