package java_codingTest_study.section12_etc_graph;
//250525

import java.util.*;
public class s12_27_re {

    static int w,h;
    static char board[][];
    static Queue<State> q ;
    static int trashCount;
    static boolean allClean;

    static Set<String> visited;

    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};


    private static class State{
        int x,y,dist;
        Set<String> cleaned;

        public State(int x, int y, int dist, Set<String> cleaned) { // cleaned : 2,3 | 1,1;1,3;
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.cleaned = cleaned;
        }
    }

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        while(true){

            w=sc.nextInt();
            h = sc.nextInt();

            if(w==0 && h==0) return;

            allClean=false;
            board=new char[h][w];
            q = new ArrayDeque<>();
            trashCount=0;
            visited = new HashSet<>();

            for(int i=0;i<h;i++){
                String s = sc.next();
                for(int j=0;j<s.length();j++){
                    board[i][j] = s.charAt(j);
                    if(board[i][j]=='o') q.offer(new State(i, j,0,new HashSet<>()));
                    else if(board[i][j]=='*') trashCount++;
                }
            }

            BFS();
            if(!allClean) System.out.println(-1);
        }





    }
    private static void BFS(){ // 쓰레기 모두 발견시 return;
        while(!q.isEmpty()){
            int len = q.size();

            for(int k=0;k<len;k++){
                State s = q.poll();

                int x=s.x; int y=s.y ; int dist= s.dist;

                for(int i=0;i<=3;i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    // 1,1

                    if(0>nx || nx>=h || 0>ny || ny>=w) continue;

                    if(board[nx][ny]=='x') continue;

                    String cur = nx + "," + ny; // 1,2

                    Set<String> cleaned = new HashSet<>(s.cleaned);
                    if(board[nx][ny]=='*'){
                        cleaned.add(nx+","+ny); // cleaned :1,2
                    }

                    String key=cur+"|"+ sort(cleaned); // (1,2) | (1,3)

                    //visited : (1,2) | (1,3);(2,4)

//                    System.out.println("key:"+key+" dist:"+dist);
//                    System.out.println("visited:" + visited);
//

                    if(!visited.contains(key)){ //not visit


                        visited.add(key);//청소
                        q.offer(new State(nx, ny, dist + 1, cleaned));

                        if(cleaned.size()==trashCount) {
                            System.out.println(dist+1);
                            allClean=true;
                            return;
                        }
                    }
                }
            }
        }
    }
    private static String sort(Set<String> set){
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        return String.join(";",list);
    }
}
/*

 현재좌표 already clean. 중복퍼짐 방지
 (2,3) | (1,1)(1,3)

 현좌표   청소한구역
 (2,3) | (1,1)
 (2,3) | (1,1) (3,5)


 */