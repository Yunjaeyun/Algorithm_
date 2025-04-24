package java_codingTest_study.section12_etc_graph;
import java.util.*;

public class s12_04_1987_way2 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static char[][] board;
    static boolean[] alpha = new boolean[26];
    static int r, c;

    static List<Integer> pathLengths = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();

        board = new char[r][c];
        for (int i = 0; i < r; i++) {
            String line = sc.next();
            for (int j = 0; j < c; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        alpha[board[0][0] - 'A'] = true;
        dfs(0, 0, 1);

        System.out.println(Collections.max(pathLengths));
    }

    private static void dfs(int x, int y, int count) {
        boolean hasNext = false;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < r && 0 <= ny && ny < c) {
                char next = board[nx][ny];
                if (!alpha[next - 'A']) {
                    alpha[next - 'A'] = true;
                    dfs(nx, ny, count + 1);
                    alpha[next - 'A'] = false;
                    hasNext = true;
                }
            }
        }

        // 더 이상 진행할 수 없는 경우: 경로 종료 !hasNext는 'hasNext == false'와 같음
        if (!hasNext) pathLengths.add(count);
    }
}
