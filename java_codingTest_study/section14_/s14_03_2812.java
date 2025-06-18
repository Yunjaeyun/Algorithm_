package java_codingTest_study.section14_;
//25 06 12

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class s14_03_2812 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());



        char[] c=br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();

        Deque<Character> queue = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            while(!queue.isEmpty() && queue.peekLast()<c[i] && k>0){
                queue.pollLast();
                k--;
            }
            queue.addLast(c[i]);


        }

        while(k-- >0){
            queue.pollLast();
        }

        for(char x:queue) sb.append(x);


        System.out.println(sb);


    }
}
