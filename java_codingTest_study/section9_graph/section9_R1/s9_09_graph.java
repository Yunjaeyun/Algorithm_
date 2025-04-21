package java_codingTest_study.section9_graph.section9_R1;
//25 03 06

import java.util.*;

public class s9_09_graph {
    static int n, m;
    static int[]ch;
    static int[]cb;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //1-4
        m = sc.nextInt(); //2

        ch = new int[n + 1];
        cb = new int[m];
        DFS(0,1);
    }

    private static void DFS(int L, int start_i){
        if(L==m){
            System.out.println(Arrays.toString(cb));
        }else{
            for(int i=start_i;i<=n;i++){
                if(ch[i]==0){
                    ch[i]=1;
                    cb[L] = i;  // not cb[m] not cb[i]
                    DFS(L + 1,i);
                    ch[i] = 0;

                }
            }
        }
    }

}
/*
	public void DFS(int L, int s){
		if(L==m){
			for(int x : combi) System.out.print(x+" ");
			System.out.println();
		}
		else{
			for(int i=s; i<=n; i++){
				combi[L]=i;
				DFS(L+1, i+1);
			}
		}
	}


 */