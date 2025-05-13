package java_codingTest_study.section12_etc_graph;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

//25 05 03 03540449
class Point1{
    int x,y,z;

    Point1(int x, int y, int z){
        this.x=x;
        this.y=y;
        this.z=z;
    }
}
public class s12_12_6593 {
    static Queue<Point1> q;
    static boolean visited[][][];
    static char[][][]building;

    static int L,R,C;

    static int[]dx={-1,1,0,0,0,0};
    static int[]dy={0,0, -1,0,1,0};
    static int[]dz={0,0,  0,1,0,-1};

    static int minute;

    static boolean escaped;

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        while(true){
            L = sc.nextInt();
            R = sc.nextInt();
            C = sc.nextInt();

            if(L==0 && R==0 && C==0) break;

            q = new ArrayDeque<>();
            visited = new boolean[L][R][C];
            minute=0;
            escaped=false;

            building = new char[L][R][C];


            for(int i=0;i<L;i++){

                for(int j=0;j<R;j++){
                    String s = sc.next();

                    for(int k=0;k<C;k++){
                        building[i][j][k] = s.charAt(k);
                        if(building[i][j][k]=='S') q.offer(new Point1(i, j, k));

                    }
                }
            }

            bfs();
            if(escaped) System.out.println("Escaped in "+minute+" minute(s).");
            else System.out.println("Trapped!");

        }

    }
    private static void bfs(){
        while(!q.isEmpty()){
            int len = q.size();

            for(int k=0;k<len;k++){
                Point1 cur = q.poll();

                int x = cur.x;
                int y = cur.y;
                int z = cur.z;

                if(building[x][y][z]=='E') {
                    escaped=true;
                    return;
                }

                for(int i=0;i<=5;i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    int nz = z + dz[i];

                    if(0<=nx && nx<L && 0<=ny && ny<R && 0<=nz && nz<C){
                        if( !visited[nx][ny][nz] && building[nx][ny][nz]!='#'){
                            visited[nx][ny][nz]=true;
                            q.offer(new Point1(nx, ny, nz));
                        }
                    }

                }
            }
            minute++;
        }
    }
}

/*
최단시간이니까 bfs로 탈출해야되는것 까진 ok
아니 근데, 층 간 이동은 어케하는지 안나와있는데

아3차원 배열
 */