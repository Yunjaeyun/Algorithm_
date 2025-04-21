package java_codingTest_study.section10_greedy.section10_R2;
//25 03 24


import java.util.*;
class Man implements Comparable<Man>{
    int tall,we;
    Man(int t, int w){
        this.tall=t;
        this.we=w;
    }
    @Override
    public int compareTo(Man other){
        return other.tall-this.tall;
    }

    @Override
    public String toString(){
        return tall+" "+we;
    }
}
public class s10_01_greedy {
    static List<Man> arr=new ArrayList<>();
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=0;i<n;i++){
            int tall = sc.nextInt();
            int weight = sc.nextInt();
            arr.add(new Man(tall, weight));
        }

        arr.sort(null);

//        System.out.println(arr);

        int max_weight=arr.get(0).we;
        int answer=1;

        for(int i=1;i<n;i++){
            if(arr.get(i).we>max_weight){
                max_weight= arr.get(i).we;
                answer++;
            }
        }
        System.out.println(answer);
    }
}
/*
183 65
181 60, <-183 키에서는 졌지만 65 몸무게만 이기면됨.
180 70,
172 67,
170 72]
 */