package java_codingTest_study.section12_etc_graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class s12_05_14889 {
    static int[]cm;
    static int n;

    static int[][] map;

    static int answer = Integer.MAX_VALUE;


    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        map = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                map[i][j] = sc.nextInt();
            }
        }

        cm = new int[n / 2];
        dfs(0, 1);
        System.out.println(answer);
    }
    private static void dfs(int L, int s){
        if(L==n/2){  //cm
            List<Integer> Lteam= makeLinkTeam(cm);
            int result = getDifference(Lteam, cm);

            answer = Math.min(answer, result);



        }else{
            for(int i=s;i<n;i++){
                cm[L] = i;
                dfs(L + 1, i + 1);
            }
        }
    }
    private static List<Integer> makeLinkTeam(int[]cm){
        boolean[] selected = new boolean[n+1];
        for(int x:cm) selected[x]=true;

        List<Integer> linkTeam = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            if(!selected[i])linkTeam.add(i);

        return linkTeam;
    }
    private static int getDifference(List<Integer> Lteam, int[] cm){
        List<Integer> Steam = new ArrayList<>();
        for(int x:cm) Steam.add(x);

        int totalLteam=getTotal(Lteam);
        int totalSteam=getTotal(Steam);

        return Math.abs(totalLteam-totalSteam);
    }
    private static int getTotal(List<Integer> team){
        int sum=0;

        for(int i=0;i<team.size();i++){
            for(int j=i+1;j<team.size();j++){

                int a = team.get(i);
                int b = team.get(j);

                sum += map[a-1][b-1];
                sum += map[b-1][a-1];
            }
        }

        return sum;
    }



}
/*

팀을 뽑는 경우의수
4/2=2인씩 2개 팀
1 2 3 4
12 34
13 24
14 23

6/2 = 3인씩 2개팀
1 2 3 4 5 6 번
123 /456
124 /356
125
126
234 ...
              l s
            d(0,1)
            1/|2|3|4|5 6\
          d(1)
         /|2|3|4|5 6\




각 팀에 따른 능력치 ex
n=6
case 1) 123 456
1 2 에 해당하는 인덱스값 map[2][1] +=
1 3                      [3][1]
2 3                      [3][2]




 */