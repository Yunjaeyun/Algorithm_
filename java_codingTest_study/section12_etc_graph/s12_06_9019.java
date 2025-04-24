package java_codingTest_study.section12_etc_graph;
//25 04 24

import java.util.*;
class Info{
    int x;
    String s;
    Info(int x, String s){
        this.x=x;
        this.s=s;
    }
}
public class s12_06_9019 {
    static Queue<Info> q;
    static boolean visited[] = new boolean[100001];
    static char[] dx = {'D', 'S', 'L', 'R'};

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
//        System.out.println((1000  % 1000) *10 + (1000 /1000));
//        System.out.println((1000 %10)*1000 + (1000 /10));

        int n = sc.nextInt();

        for(int i=0;i<n;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            Arrays.fill(visited, false);
            q = new ArrayDeque<>();

            q.add(new Info(a,""));
            visited[a]=true;
            bfs(a, b);
        }
    }
    private static void bfs(int a, int b){


        while(!q.isEmpty()){
            //cur=q.poll
            int len = q.size();
            for(int j=0;j<len;j++){
                Info cur = q.poll();

                if(cur.x==b) {
                    System.out.println(cur.s);
                    return;
                }

                for(int i=0;i<=3;i++){
                    int nx = apply(cur.x, dx[i]);
                    if(!visited[nx]){
                        visited[nx]=true;
                        q.add(new Info(nx, cur.s + dx[i]));
                    }

                }

            }

        }

    }
    private static int apply(int n, char op){
        switch(op){
            case 'D':
                n=n*2;
                if(n>9999) return n%10000;
                return n;

            case 'S':
                return n == 0 ? 9999 : n - 1;
            case 'L':
                return (n % 1000) *10 + (n/1000);
            case 'R':
                return (n%10)*1000 + (n/10);

        }
        return n;
    }

}
/*

1234 left Shift -> 2341
1234 % 1000 =234

234*10 +1
      -> 1234 /1000
(n % 1000) *10 + (n/1000)


1234 right shift 4123
1234 /10= 123....4

a/10
a%10

(n%10)*1000 + (n/10)

 */