package java_codingTest_study.section4_투포인터_slidingWindow;
import java.util.*;
public class s4_05_way2_수학 {


    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int cnt=1,answer=0;

        n--;
        while(n>0){
            cnt++;
            n-=cnt;
            if(n%cnt==0) answer++;;


        }
        System.out.println(answer);
    }
}
