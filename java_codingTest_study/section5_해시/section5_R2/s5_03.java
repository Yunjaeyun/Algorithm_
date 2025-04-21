package java_codingTest_study.section5_해시.section5_R2;
//25 04 11

import java.util.*;
public class s5_03 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<k;i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1); // a:1,b:2
        }
        result.add(map.size());

        for(int i=k;i<n;i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);// a:1,b:3
            int value = map.get(arr[i-k]);
            map.put(arr[i-k], value - 1);

            if(value-1 ==0) map.remove(arr[i-k]);

            result.add(map.size());
        }
        for(int x:result) System.out.print(x + " ");

    }
}
/*
4 5 6 i
0 1 2
4 4 4 k
 */