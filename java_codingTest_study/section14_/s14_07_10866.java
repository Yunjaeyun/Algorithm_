package java_codingTest_study.section14_;
//25 06 18
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class s14_07_10866 {
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer();

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch(st.nextToken()){
                case "push_front":
                    q.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    q.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if(q.isEmpty()) System.out.println(-1);
                    else System.out.println(q.poll());
                    break;
                case "pop_back":
                    if(q.isEmpty()) System.out.println(-1);
                    else System.out.println(q.pollLast());
                    break;
                case "size":
                    System.out.println(q.size());
                    break;
                case "empty":
                    if(q.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;
                case "front":
                    if(q.isEmpty()) System.out.println(-1);
                    else System.out.println(q.peekFirst());
                    break;
                case "back":
                    if(q.isEmpty()) System.out.println(-1);
                    else System.out.println(q.peekLast());
                    break;
            }
        }


    }

}
