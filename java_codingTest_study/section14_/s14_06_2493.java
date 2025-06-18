package java_codingTest_study.section14_;
//25 06 17

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class s14_06_2493 {

    private static class Bar{
        int idx, h;

        public Bar(int idx, int h) {
            this.idx = idx;
            this.h = h;
        }
    }
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        Deque<Bar> q = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] ans = new int[n];

        for(int i=n-1;i>=0;i--){
            int curH = arr[i];

            // 더 높은게 나오면 기록
            while(!q.isEmpty() && curH > q.peekLast().h){

                Bar right=q.pollLast();
                ans[right.idx]=i+1;

            }
            q.addLast(new Bar(i, curH));
        }
//        while(!q.isEmpty()){
//            q.pollLast();
//            answer.add(0);
//        } 남은건 어차피 0임.

        for(int x:ans) System.out.print(x + " ");
    }
}
