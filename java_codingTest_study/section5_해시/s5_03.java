package java_codingTest_study.section5_해시;
//25 02 01
import java.util.*;
import java.lang.*;
//  0  1  2  3  4  5  6
//  20 12 20 10 23 17 10

//  20 12 20
//  {20:1,  12:1,   10:1}
//
//  20 12 20 10
//
/*  {20:2,  12:1,   10:1}
----------------------------------
    {20:1,  12:1,   10:1,   23:1}
 */
public class s5_03 {


    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n;i++) arr[i]=sc.nextInt();
        func(arr, n,k);
    }
    private static void func(int[]arr, int n,int k){
        int rt=0, lt=0, cnt=0;
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        // two pointer 써서 구간 만들고
        for(int i=0;i<k-1;i++){ //k=4, k-1=3
            int y = map.getOrDefault(arr[i], 0);
            map.put(arr[i], y + 1);
        }


        for(rt=k-1;rt<n;rt++){
            int y = map.getOrDefault(arr[rt], 0);
            map.put(arr[rt], y + 1);
            /** k개 매출기록 완성**/
            result.add(map.size());

            /** 삭제*/

            int b=map.get(arr[lt])-1;
            map.put(arr[lt],b);
            if(b==0) map.remove(arr[lt]);
            lt++;
        }
        for (int x:result) System.out.print(x + " ");

    }
}
