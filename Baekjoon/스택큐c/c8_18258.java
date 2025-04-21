package Baekjoon.스택큐c;
import java.util.*;
import java.io.*;
import java.lang.*;
public class c8_18258 {

    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n=Integer.parseInt(br.readLine());

        Deque<Integer> q = new ArrayDeque();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++){
            String cmd[]= br.readLine().split(" ");

            switch(cmd[0]){
                case "push":
                    q.offer(Integer.parseInt(cmd[1]));
                    break;
                case "pop":
                    if (q.isEmpty()) {
                        sb.append("-1\n");
                        break;
                    }
                    sb.append(q.poll()).append("\n");
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    if(q.isEmpty()){
                        sb.append("1\n");
                        break;
                    }
                    sb.append("0\n");
                    break;
                case "front":
                    if(q.isEmpty()){
                        sb.append("-1\n");
                        break;
                    }
                    sb.append(q.peek()).append("\n");
                    break;

                case "back":
                    if(q.isEmpty()){
                        sb.append("-1\n");
                        break;
                    }
                    sb.append(q.peekLast()).append("\n");
                    break;

            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}
