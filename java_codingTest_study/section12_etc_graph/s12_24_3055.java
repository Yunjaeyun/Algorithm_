package java_codingTest_study.section12_etc_graph;
//250520

import java.util.*;
public class s12_24_3055 {
    static int r, c;
    static char[][] board;
    static int dist;
    static boolean visited[][];

    static Info goSeumdochi;
    static List<Info> waterInfo = new ArrayList<>();
    static Queue<Info> q = new ArrayDeque<>();

    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static boolean escape = false;


    private static class Info {
        int x, y, dis;

        Info(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();

        board = new char[r][c];
        visited = new boolean[r][c];
        // * 물  X돌

        // 물도 bfs, 고슴도치도 bfs 같이?

        for (int i = 0; i < r; i++) {
            String s = sc.next();
            for (int j = 0; j < s.length(); j++) {
                board[i][j] = s.charAt(j);
                if (board[i][j] == 'S') goSeumdochi = new Info(i, j, 0);
                else if (board[i][j] == '*') waterInfo.add(new Info(i, j, 0));
            }
        }


        for (Info info : waterInfo) {
            q.offer(info);
        }
        q.offer(goSeumdochi);
        visited[goSeumdochi.x][goSeumdochi.y] = true;


        BFS();
        System.out.println(escape ? dist : "KAKTUS");
    }

    private static void BFS() {
        while (!q.isEmpty()) {

            int len = q.size();

            for (int k = 0; k < len; k++) {



                Info cur = q.poll();
                int x = cur.x;
                int y = cur.y;

                if (board[x][y] == 'D') {
                    escape = true;
                    dist = cur.dis; //*
                    return;
                }


                // 물 일 경우
                if (board[x][y] == '*') {
                    for (int i = 0; i <= 3; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];

                        if (0 > nx || nx >= r || 0 > ny || ny >= c) continue;

                        if (board[nx][ny] == '.') {
                            board[nx][ny] = '*';
                            q.offer(new Info(nx, ny, cur.dis));

                        }
                    }

                // 고슴도치일 경우
                }else if (board[x][y] == 'S') {
                    for (int i = 0; i <= 3; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];

                        if (0 > nx || nx >= r || 0 > ny || ny >= c) continue;

                        if(board[nx][ny]=='D') {
                            escape = true;
                            dist = cur.dis+1; //*
                            return;
                        }


                        if (!visited[nx][ny] && board[nx][ny] != '*' && board[nx][ny] != 'X') {
                            visited[nx][ny] = true;
                            board[nx][ny] = 'S';
                            q.offer(new Info(nx, ny, cur.dis + 1));
                        }
                    }
                }
            }

        }
    }
}
