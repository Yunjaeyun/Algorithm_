package java_codingTest_study.section9_graph.section9_R1;
//25 03 09

import java.util.*;
class Point2 {
    int x,y;
    public Point2(int x, int y){
        this.x=x;
        this.y=y;
    }
}
public class s9_15_graph {
    static int n, m;
    static int[][]board;


    static int[]cm;
    static int[]ch;

    static List<Point2> pizza = new ArrayList<>();
    static List<Point2> home = new ArrayList<>();

    static int result=Integer.MAX_VALUE;
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        cm = new int[n];

        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();

                if (board[i][j] == 2) pizza.add(new Point2(i, j));
                else if(board[i][j]==1) home.add(new Point2(i, j));
            }

        }
        ch=new int[pizza.size()];

        DFS(0, 0);
        System.out.println(result);
    }

    private static void DFS(int L, int S){
        if(L==m){
            System.out.println(Arrays.toString(cm));

            int sum=0;
            for(Point2 h:home){ //(1,2) (2,3)
                int answer=Integer.MAX_VALUE;

                for(int i:cm){ //0,1,2,3
                    answer=Math.min(answer, Math.abs(h.x-pizza.get(i).x)+Math.abs(h.y-pizza.get(i).y));

                }
                sum+=answer;

            }
            result = Math.min(result,sum);


        }else{
            for(int i=S;i<pizza.size();i++){
                if(ch[i]==0){
                    cm[L]=i;
                    DFS(L + 1, i +1);
                }
            }
        }
    }
}
/*
집을 다 받아.
(1,2) (3,4) (4,2)

집집마다
조합개수에대한 피자집에 대한 최소거리를 구함.
4c3

1번집
1피자집 2피자집 3피자집 -> 거리 다 더함
1피자집 2피자집 4피자집 -> 거리 다 더함

2번집
1피자집 2피자집 3피자집 4피자집 -> 그중 최소거리
 */
