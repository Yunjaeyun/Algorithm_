package java_codingTest_study.section9_graph.section9_R2;
//25 03 20
import java.awt.*;
import java.util.*;
import java.util.List;

class Point{
    int x, y;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}
public class s9_15_graph {
    static int n,m;
    static int board[][];
    static List<Point> home=new ArrayList<>();
    static List<Point> pizza_store=new ArrayList<>();

    static int cm[];
    static int ch[];

    static int result = Integer.MAX_VALUE;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        board = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = sc.nextInt();
                if(board[i][j]==1) home.add(new Point(i, j));
                else if(board[i][j]==2) pizza_store.add(new Point(i, j));
            }
        }

        cm = new int[m];
        ch = new int[pizza_store.size() + 1];
        combi(0,1);
        System.out.println(result);


// home (1,2)(3,4)..
    }
    private static void combi(int L, int start){
        if(L==m){
//            System.out.println(Arrays.toString(cm)); // 1 2 3 4
            int answer=0;
            for(Point h:home){
                int dis=Integer.MAX_VALUE;

                for(int x:cm){
                    Point pizza = pizza_store.get(x - 1);
                    dis=Math.min(dis, Math.abs(h.x-pizza.x)+Math.abs(h.y-pizza.y));

                }
//                System.out.println("dis:"+dis);
                answer+=dis;
//                System.out.println("answer:"+answer);

            }
            result = Math.min(result, answer);

        }else{
            for(int i=start;i<=pizza_store.size();i++){
                if(ch[i]==0){
                    ch[i]=1;
                    cm[L] = i;
                    combi(L+1,i);
                    ch[i]=0;
                }
            }
        }
    }
}
/*
if피자집 ->
 그리고 배열에 박아(나중에 size로 피자집개수p 알아내고)
 1부터 p까지 m개 선택하는 dfs->
 ex) 1부터 6중 4개 선택

 1 2 3 4 -> 인덱스로써야됨. 조합의 문제임. 1234 랑 1243이랑 같음.순열 아님

            d(0)
            /1/2|3|4\5\6
           d(1)
         /1/2|3|4\5\6
          d(2)
      /1/2|3|4\5\6
          d(3)
      /1/2|3|4\5\6
        d(4)


 그리고 집도 찾아서 따로 만듬.
 각 집마다
 모든 피자집돌면서 최고의 거리인 피자집 선택+=

   */