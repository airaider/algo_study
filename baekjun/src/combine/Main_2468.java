package combine;

import java.util.Scanner;

public class Main_2468 {
	static int map [][];
	static int N;
	static boolean visit [][];
	static int dir[][]= {
			{1,0},
			{-1,0},
			{0,1},
			{0,-1}
	};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int [N][N];
		int max=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j]>max) {
					max=map[i][j];
				}
			}
		}
		int cnt;
		int ans=1;
		for(int t=1;t<max;t++) {
			visit = new boolean [N][N];
			cnt=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visit[i][j] && map[i][j]>t) {
						dfs(i,j,t);
						cnt++;
					}
				}
			}
			if(ans<cnt) {
				ans=cnt;
			}
			
		}
		System.out.println(ans);
		
	}
	private static void dfs(int x, int y, int t) {
		visit[x][y]=true;
		for(int i=0;i<4;i++) {
			int nx = x+dir[i][0];
			int ny = y+dir[i][1];
			if(0<=nx && nx<N && 0<=ny && ny<N) {
				if(map[nx][ny]>t && !visit[nx][ny]) {
					dfs(nx,ny,t);
				}
			}
			
		}
	}

}
