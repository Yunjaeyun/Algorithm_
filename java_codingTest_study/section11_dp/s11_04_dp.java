package java_codingTest_study.section11_dp;
import java.util.*;

class Brick implements Comparable<Brick>{
    int size, weight, height;
    Brick(int s, int w, int h){
        this.size = s;
        this.weight = w;
        this.height = h;
    }
    @Override
    public int compareTo(Brick other){
        // size 기준 내림차순 정렬
        return other.size - this.size;
    }
}

public class s11_04_dp {
    static List<Brick> arr;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            int s = sc.nextInt();
            int h = sc.nextInt();
            int w = sc.nextInt();
            arr.add(new Brick(s, w, h));
        }
        // 내림차순 정렬(가장 큰 size 벽돌이 arr.get(0))
        arr.sort(null);

        System.out.println(sol());
    }

    private static int sol(){
        int[] dy = new int[arr.size()];
        // 모든 벽돌을 "혼자 쌓았을 때" 높이로 초기화
        for(int i=0; i<arr.size(); i++){
            dy[i] = arr.get(i).height;
        }

        int answer = dy[0];

        // i번째 벽돌을 꼭대기로 쌓을 수 있는 최대 높이
        for(int i=1; i<arr.size(); i++){
            for(int j=0; j<i; j++){
                // j 벽돌이 더 무겁다면 i를 위에 쌓을 수 있다
                if(arr.get(j).weight > arr.get(i).weight){
                    // j까지 쌓은 높이 + i 벽돌 높이로 갱신
                    dy[i] = Math.max(dy[i], dy[j] + arr.get(i).height);
                }
            }
            answer = Math.max(answer, dy[i]);
        }
        return answer;
    }
}
