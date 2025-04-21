package java_codingTest_study.section5_해시.section5_R1;
//25 03 30

import java.util.*;
public class s5_03 {
    public static void main(String[]args){
        List<Integer> result = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<k;i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        System.out.println(map);
        result.add(map.size());


        for(int i=k;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i], 0)+1);

            map.put(arr[i-k],map.get(arr[i-k])-1);
            if(map.get(arr[i-k])==0) map.remove(arr[i - k]);

            System.out.println(map);
            result.add(map.size());
        }
        System.out.println(result);
    }
}
/*
i 4 5 6
k 4 4 4
  0 1 2
 */