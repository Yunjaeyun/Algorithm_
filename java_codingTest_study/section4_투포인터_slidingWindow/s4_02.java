package java_codingTest_study.section4_투포인터_slidingWindow;
import java.util.*;
import java.lang.*;
public class s4_02 {


    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] first = new int[n];
        for (int i = 0; i < n; i++) first[i] = sc.nextInt();

        int m = sc.nextInt();
        int[] second = new int[m];
        for (int i = 0; i < m; i++) second[i] = sc.nextInt();

        Arrays.sort(first);
        Arrays.sort(second);
        check(n, first, m, second);
    }

    private static void check(int n,int[] arr_1, int m, int[] arr_2){
        int p1=0;
        int p2=0;

        List<Integer> result = new ArrayList<>();

        while(p1<n && p2<m){
            if(arr_1[p1]<arr_2[p2]) p1++;
            else if(arr_1[p1]>arr_2[p2]) p2++;
            else {
                result.add(arr_1[p1]);
                p1++; p2++;
            }
        }
        for(int x:result) System.out.print(x + " ");

    }
}
// two pointer 정렬은 오름차순을 해야함. 아니면 무시되어버리는 숫자가 존재함.