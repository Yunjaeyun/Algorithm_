package java_codingTest_study.section10_greedy;
//25 02 19

import java.util.*;

class Person implements Comparable<Person>{
    public int height, weight;
    Person(int h, int w){
        this.height=h;
        this.weight = w;
    }
    @Override
    public int compareTo(Person o){ // 내림차순 want : 음수
        return    o.height-this.height;
    }


}
public class s10_01_greedy {
    static List<Person> arr;
    static int max_weight = Integer.MIN_VALUE;
    static int cnt=0;

    private static void solution(List<Person> arr,int n){
        arr.sort(null);
        for(Person p:arr){
            if(p.weight > max_weight){
                max_weight = p.weight;
                cnt++;
            }
        }
    }


    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new ArrayList<>();

        for(int i=0;i<n;i++){
            int h = sc.nextInt();
            int w = sc.nextInt();
            arr.add(new Person(h, w));
        }
        solution(arr, n);
        System.out.println(cnt);
    }
}
/*
내림차순
class Person implements Comparable<Person>{
    int age
    String name

    @Override
    public int compareTo(Person o){
        return o.age-this.age;
    }

   기준을 "나"this 라고 잡자.
   앞에 오면 무조권 작은거다.

   비교 결과	                  | compareTo가 주는 숫자  |	 뜻
   ----------------------------------------------------------
   A(1)가 B(10)보다 작다(앞이다) | 음수(-)	             |  "A가 B보다 앞에 와요!"

오름차순
class Person implements Comparable<Person>{
    int age;
    String name;

    public int compareTo(Person o){
        return this.age-o.age;
}
 */