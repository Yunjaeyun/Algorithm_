package java_codingTest_study.section10_greedy.section10_R1;
//25 03 10

import java.util.*;
class Person implements Comparable<Person>{
    int h,w;
    Person(int h,int w){
        this.h=h;
        this.w=w;
    }

    @Override
    public int compareTo(Person o){
        return o.h-this.h;
    }
}
public class s10_01_greedy {

    static List<Person> arr=new ArrayList<>();
    static int answer=1;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=0;i<n;i++){
            int h=sc.nextInt();
            int w=sc.nextInt();
            arr.add(new Person(h, w));
        }
        sol();
        System.out.println(answer);
    }
    private static void sol(){
        arr.sort(null);
        int max_w=arr.get(0).w;

        for(Person ob:arr){
            if(ob.w>max_w){
                answer++;
                max_w=ob.w;
            }
        }

    }
}
