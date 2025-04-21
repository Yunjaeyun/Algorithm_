package java_codingTest_study.section10_greedy.section10_R1;
//25 03 10

import java.util.*;

public class s10_06_greedy {

    static int unf[];
    private static int Find(int a){
        if(a==unf[a]) return a;
        else return unf[a] = Find(unf[a]);
    }
    private static void Union(int a, int b){
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb) unf[fa]=fb;
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        unf = new int[n + 1];
        for(int i=1;i<=n;i++) unf[i]=i;
        for(int i=0;i<m;i++){
            int fa = sc.nextInt();
            int fb = sc.nextInt();

            Union(fa, fb);
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        if(a==b) System.out.println("YES");
        else System.out.println("NO");
    }
}
//결국 두 원소가 같은 집합인지 확인하는문제 bfs로도 풀수있지만, union-find를 이용한다.