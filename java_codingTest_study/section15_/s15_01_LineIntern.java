package java_codingTest_study.section15_;
//250626

import java.util.*;
public class s15_01_LineIntern {
    static int c = 11;
    static int b = 2;

    public static void main(String[] args) {
        System.out.println(catchMe(c, b));  // 5

        System.out.println("정답 = 3 / 현재 풀이 값 = " + catchMe(10, 3));
        System.out.println("정답 = 8 / 현재 풀이 값 = " + catchMe(51, 50));
        System.out.println("정답 = 28 / 현재 풀이 값 = " + catchMe(550, 500));
    }

    private static class Info{
        int pos, time;

        public Info(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }
    }

    public static int catchMe(int conyLoc, int brownLoc) {

        Queue<Info> q=new ArrayDeque<>();
        q.offer(new Info(brownLoc,0));

        Map<Integer,Boolean>[] visited=new HashMap[200_001] ;
        for (int i = 0; i <= 200_000; i++) visited[i] = new HashMap<>();

        int time=0;

        while(conyLoc<=200_000){
            conyLoc+=time;
            if(conyLoc>200_000) break;

            if(visited[conyLoc].containsKey(time)) return time;

            int len = q.size();
            for(int i=0;i<len;i++){

                Info cur = q.poll();
                int []next={cur.pos+1, cur.pos-1, cur.pos*2};
                int new_time = cur.time + 1;

                for(int new_position:next){
                    if(0<=new_position && new_position<=200_000 && !visited[new_position].containsKey(new_time)){
                        visited[new_position].put(new_time, true);
                        q.offer(new Info(new_position,new_time));
                    }
                }
            }
            time++;
        }
        return -1;
    }
}
