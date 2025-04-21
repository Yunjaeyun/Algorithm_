package java_codingTest_study.section6_스택큐.section6_R1;
//25 04 03

import java.util.*;
class Person{
    int order, danger;

    public Person(int order, int danger) {
        this.order = order;
        this.danger = danger;
    }
}

public class s6_08 {
    static Queue<Person> q;
    static int n,m;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
         n = sc.nextInt();
         m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();


        q = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            q.offer(new Person(i,arr[i]));
        }
        System.out.println(sol());




    }
    private static int sol(){
        int cnt=0;

        while(!q.isEmpty()){
            Person tmp = q.poll();
            for(Person x:q){
                if(tmp.danger < x.danger) {
                    q.offer(tmp);
                    tmp=null;
                    break;

                }
            }
            if(tmp!=null) {
                cnt++;
                if (m == tmp.order) return cnt;
            }
        }
        return cnt;
    }
}
