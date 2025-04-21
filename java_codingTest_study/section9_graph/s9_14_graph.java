package java_codingTest_study.section9_graph;
//25 02 18,19

import java.util.*;
public class s9_14_graph {
    static int board[][];
    static List<Point> house_coord;
    static List<Point> pizza_coord;
    static int[] Combination;
    static int n,m,len;
    static int answer = Integer.MAX_VALUE;
    static class Point{
        public int x,y;
        public Point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    private static void DFS(int L, int s){

        if(L==m){
            int each_combination_sum=0;
            for(Point hs:house_coord){
                int dis=Integer.MAX_VALUE; //*
                for(int idx:Combination){ // 0 1 2 4
                    dis = Math.min(dis, Math.abs(hs.x - pizza_coord.get(idx).x) + Math.abs(hs.y - pizza_coord.get(idx).y));
                }
                each_combination_sum += dis;
            }
            answer = Math.min(answer, each_combination_sum);
        }else{
            for(int i=s;i<len;i++){
                Combination[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][n];

        house_coord = new ArrayList<>();
        pizza_coord = new ArrayList<>();
        Combination = new int[m];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int tmp = sc.nextInt();
                if(tmp==1) house_coord.add(new Point(i, j));
                else if(tmp==2) pizza_coord.add(new Point(i, j));
            }
        }


        len = pizza_coord.size();
        DFS(0, 0);
        System.out.println(answer);


    }
}
