package java_codingTest_study.section5_해시;
import java.util.*;
//25 02 02

/**
 *  TreeSet 중복제거, 정렬 지원
 */
public class s5_05 {

    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n;i++) arr[i]=sc.nextInt();
        System.out.println(func(n, k, arr));
    }

    private static int func(int n,int k,int []arr){
        int answer=-1;
        TreeSet<Integer> treeset = new TreeSet<>(Collections.reverseOrder());
        for(int i=0; i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int x=j+1;x<n;x++){
//                    System.out.println("i는" + arr[i] + " j는 " + arr[j] + " x는 " + arr[x]);
                    treeset.add(arr[i]+arr[j]+arr[x]);
                }
            }
        }


        int cnt=0;
        for(int a:treeset){
            cnt++;
            if(cnt==k) return a;
        }
        return answer;

    }
}
