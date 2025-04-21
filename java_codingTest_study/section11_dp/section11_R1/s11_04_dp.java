package java_codingTest_study.section11_dp.section11_R1;
//25 03 11

import java.util.*;
class Brick implements Comparable<Brick>{
    int width,height,weight;
    Brick(int wi, int h, int wd){
        this.width=wi;
        this.height=h;
        this.weight=wd;
    }
    @Override
    public int compareTo(Brick other){
        return this.width-other.width;
    }

}
public class s11_04_dp {
    static List<Brick> arr = new ArrayList<>();
    static int[] dy;
    static int answer=0;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dy = new int[n];


        for(int i=0;i<n;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            arr.add(new Brick(a, b, c));
        }



        arr.sort(null);

        for(int i=0;i<n;i++){
            dy[i]=arr.get(i).height;
        }

        for(int i=1;i<n;i++){

            for(int j=i-1;j>=0;j--){
                if(arr.get(i).weight> arr.get(j).weight){
                    dy[i] = Math.max(dy[i], arr.get(j).height + dy[i]);
                }
            }
            answer = Math.max(answer, dy[i]);
        }
        System.out.println(answer);
    }

}
