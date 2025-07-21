package java_codingTest_study.section15_;
//25 07 023
//baekjoon_17837
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class s15_05_Samsung {

    private static class Horse{
        int x,y,d;

        public Horse(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }


    static int color_board[][];

    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {1, -1, 0, 0};

    static Horse[] horse_info;
    static List<Integer>[][] horse_loc_and_dir;
    static int k;

    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        color_board = new int[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<n;j++){
                color_board[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        horse_loc_and_dir = new ArrayList[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                horse_loc_and_dir[i][j] = new ArrayList<>();
            }
        }

        horse_info = new Horse[k];
        for(int i=0;i<k;i++){

            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int d=Integer.parseInt(st.nextToken());

            horse_info[i] = new Horse(x, y, d);
            horse_loc_and_dir[x][y].add(i);

        }

        System.out.println(simulate(n,color_board,horse_loc_and_dir));


    }
//    A번 말이 이동하려는 칸이
//    1. 흰색인 경우에는 그 칸으로 이동한다. 이동하려는 칸에 말이 이미 있는 경우에는 가장 위에 A번 말을 올려놓는다.
//    A번 말의 위에 다른 말이 있는 경우에는 A번 말과 위에 있는 모든 말이 이동한다.
//    예를 들어, A, B, C로 쌓여있고, 이동하려는 칸에 D, E가 있는 경우에는 A번 말이 이동한 후에는 D, E, A, B, C가 된다.
//
//    2. 빨간색인 경우에는 이동한 후에 A번 말과 그 위에 있는 모든 말의 쌓여있는 순서를 반대로 바꾼다.
//            A, B, C가 이동하고, 이동하려는 칸에 말이 없는 경우에는 C, B, A가 된다.
//    A, D, F, G가 이동하고, 이동하려는 칸에 말이 E, C, B로 있는 경우에는 E, C, B, G, F, D, A가 된다.
//
//    3. 파란색인 경우에는 A번 말의 이동 방향을 반대로 하고 한 칸 이동한다. 방향을 반대로 바꾼 후에 이동하려는 칸이 파란색인 경우에는 이동하지 않고 가만히 있는다.
//    4. 체스판을 벗어나는 경우에는 파란색과 같은 경우이다.

    public static int simulate(int n, int[][] game_map, List<Integer>[][] cur_horse_loc_and_dir){
        int turn_count=1;
        while(turn_count<=1000){
            for(int i=0;i<k;i++){
                Horse cur = horse_info[i];

                int x=cur.x;
                int y=cur.y;
                int dir = cur.d;

                int new_x=x+dx[dir-1];
                int new_y=y+dy[dir-1];

//                cur_horse_loc_and_dir[new_x][new_y].add(i);


                List<Integer> cur_stack = cur_horse_loc_and_dir[x][y];

                // 나의 위치 idx를 찾고 [내위치:끝]은 이동
                // [:내위치]만 머무르기
                // 이동완료했으먄 Horse [] 배열에 값 새로 저장
                int start_index=0;
                for(int index=0;index<cur_stack.size();index++){
                    if(i==cur_stack.get(index)){
//                        List<Integer> to_move = cur_stack.subList(index,cur_stack.size());
//                        List<Integer> stay = cur_stack.subList(0, index);
//
//                        //말 이동
//                        cur_horse_loc_and_dir[new_x][new_y].addAll(to_move);
//                        //이동안한 말 냅두기 /  [ idx: ] 제거
//                        cur_stack.subList(index, cur_stack.size()).clear();

                        start_index=index;
                        break;
                    }
                }
//    3. 파란색2인 경우에는 A번 말의 이동 방향을 반대로 하고 한 칸 이동한다. 방향을 반대로 바꾼 후에 이동하려는 칸이 파란색인 경우에는 이동하지 않고 가만히 있는다.
//    4. 체스판을 벗어나는 경우에는 파란색과 같은 경우이다.


                if(new_x<0 || new_y<0 || new_x>=n || new_y>=n || (game_map[new_x][new_y]==2)){
                    int new_dir = get_change_dir(dir);
                    horse_info[i].d=new_dir;
                    new_x = x + dx[new_dir-1];
                    new_y = y + dy[new_dir-1];

                    if(new_x<0 || new_y<0 || new_x>=n || new_y>=n || (game_map[new_x][new_y]==2)) {
                        continue;


// 파란색   | 빨간색 흰색
// 말 이동x   말 이동o
//    2. 빨간색1인 경우에는 이동한 후에 A번 말과 그 위에 있는 모든 말의 쌓여있는 순서를 반대로 바꾼다.
                    }
                }

                // 이동할 말들 [2:]
                List<Integer> to_move =new ArrayList<>( cur_stack.subList(start_index,cur_stack.size()));

                //말 이동
//                cur_horse_loc_and_dir[new_x][new_y].addAll(to_move);

                //이동안한 말 냅두기= /  [ idx: ] 제거
                cur_stack.subList(start_index, cur_stack.size()).clear();

                if(game_map[new_x][new_y]==1){

                    Collections.reverse(to_move);

//    1. 흰색0인 경우에는 그 칸으로 이동한다. 이동하려는 칸에 말이 이미 있는 경우에는 가장 위에 A번 말을 올려놓는다.
//    A번 말의 위에 다른 말이 있는 경우에는 A번 말과 위에 있는 모든 말이 이동한다.

                }
                cur_horse_loc_and_dir[new_x][new_y].addAll(to_move);



                // 이동한 말들 [2:]좌표정보 수정
                // 말 이동 후에 Horse horse_info[] 업데이트
                for(int horse:to_move){
                    horse_info[horse].x=new_x;
                    horse_info[horse].y=new_y;
                }


                if(horse_loc_and_dir[new_x][new_y].size()>=4) return turn_count;

            }


            turn_count++;
        }


        return -1;
    }

    public static int get_change_dir(int dir){
        switch (dir){
            case 1:
                return 2;
            case 2:
                return 1;
            case 3:
                return 4;
            case 4:
                return 3;
        }
        return -1;
    }
}
/*
구현 고민 포인트 : 쌓는거. x차원 배열? -> List<Integer> [][]=new ArrayList<>()


동  서 북 남
→,  ←, ↑, ↓
1   2  3  4
[0, 0, -1, 1]
[1,-1, 0, 0]

1->2
2->1
3->4
4->3



 */