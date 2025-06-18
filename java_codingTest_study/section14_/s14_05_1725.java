package java_codingTest_study.section14_;
//25 06 16

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class s14_05_1725 {

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

        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }


        Deque<Bar> q = new ArrayDeque<>();

        long maxExtent=0;

        for(int i=0;i<=n;i++){
            int curH = (i == n) ? 0 : arr[i];
            int startIndex=i;

            while (!q.isEmpty() && curH < q.peekLast().h) {

                Bar top = q.pollLast();
                long extent = (long)top.h * (i - top.idx);
                maxExtent = Math.max(maxExtent, extent);
                startIndex = top.idx;
            }
            q.addLast(new Bar(startIndex, curH));

        }
        System.out.println(maxExtent);

    }
}
