package java_codingTest_study.section4_투포인터_slidingWindow;
//25 01 30
import java.util.*;
import java.lang.*;
public class s4_01 {


    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] first_arr = new int[n];
        for (int i = 0; i < n; i++) first_arr[i] = sc.nextInt();

        int m = sc.nextInt();
        int[] second_arr = new int[m];
        for (int i = 0; i < m; i++) second_arr[i] = sc.nextInt();

        check(n,first_arr,m, second_arr);
    }
    private static void check(int n,int[] arr_1, int m, int[] arr_2){
        int p1=0;
        int p2=0;

        List<Integer> list = new ArrayList<>();
/** n=3
 *  0   1   2
 *  1   3   5
 *  2   3   6   7   9
 *
 *  p1 :2, p2:2
 *  1233
 */
        while(p1<n && p2<m){
            if(arr_1[p1]<arr_2[p2]) list.add(arr_1[p1++]);
            else list.add(arr_2[p2++]);
        }
        while(p1<n) list.add(arr_1[p1++]);
        while(p2<m) list.add(arr_2[p2++]);

        for(int x:list){
            System.out.print(x + " ");
        }
    }
}
