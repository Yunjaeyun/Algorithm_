package java_codingTest_study.section12_etc_graph;
//25 04 27,05 01 17:15

import java.util.*;
public class s12_09_15684 {
    static int N,M, H, answer;
    static int[][]ladder;
    static List<int[]> candidates = new ArrayList<>();
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        H = sc.nextInt();

        ladder = new int[H+1][N+1+1];

        for(int i=0;i<M;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            ladder[a][b]=1;
        }

        for(int h=1;h<=H;h++){
            for(int i=1;i<=N;i++){
                if(ladder[h][i]==0 && ladder[h][i-1]==0 && ladder[h][i+1]==0)
                    candidates.add(new int[]{h, i});
            }
        }

        answer=Integer.MAX_VALUE;
        dfs(0, 0);
        System.out.println(answer > 3 ? -1 : answer);


    }
    private static void dfs(int L, int S){
        if(L>3) return;

        if(check()){
            answer = Math.min(answer, L);
        }

        for(int i=S;i<candidates.size();i++){
            int x=candidates.get(i)[0];
            int y=candidates.get(i)[1];

            ladder[x][y]=1;
            dfs(L + 1,i+1 );
            ladder[x][y]=0;
        }


    }

    //for i {
    //    시작i -> 끝도 i인가(성공)
    //       }
    private static boolean check(){
        for(int k=1;k<=N;k++){
            int now = k;

            for(int i=1;i<=H;i++){
                if(ladder[i][now]==1) now++;
                else if(ladder[i][now-1]==1) now--;
            }

            if(k!=now) return false;
        }
        return true;
    }

}
