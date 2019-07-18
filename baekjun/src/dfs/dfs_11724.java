package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dfs_11724 {
	static int[][] m;
	static int N;
	static int M;
	static int cnt=0;
	static boolean[] visit; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
		m = new int [N+1][N+1];
		visit = new boolean[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
			m[x][y]=1;
			m[y][x]=1;
		}
		for (int i = 1; i <= N ; i++) { //i is a index of node to visit
            if(visit[i] == false){
                cnt++;
                dfs(i);
            }
        }
		System.out.println(cnt);
	}


	private static void dfs(int k) {
		visit[k]=true;
		for(int i = 1; i <= N; i++) {
			if(visit[i]==false && m[k][i]==1) {
				dfs(i);
				
			}
		}
	}

}
