package java_codingTest_study.section11_dp.section11_R2;
//25 03 24

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
class Brick implements Comparable<Brick>{
    int wd,h,we;

    public Brick(int wd, int h, int we) {
        this.wd = wd;
        this.h = h;
        this.we = we;
    }

    @Override
    public int compareTo(Brick other){
        return other.wd-this.wd;
    }
}
public class s11_04_dp {
    static List<Brick> arr = new ArrayList<>();
    static int dis[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        dis = new int[n];
        for(int i=0;i<n;i++){
            int a=sc.nextInt() ;
            int b=sc.nextInt() ;
            int c=sc.nextInt() ;
            arr.add(new Brick(a, b, c));
        }

        arr.sort(null);

        for(int i=0;i<n;i++){
            dis[i]=arr.get(i).h;
        }

        int answer = Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
            Brick cur = arr.get(i);

            for(int j=0;j<i;j++){
                if(cur.we<arr.get(j).we){
                    dis[i] = Math.max(dis[i], dis[j]+cur.h);
                }
            }
            answer = Math.max(answer, dis[i]);
        }
        System.out.println(answer);


    }
}
