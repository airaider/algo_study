package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503_로봇청소기 {
	static int map[][];
	static int dir[][]= {
			{-1,0},
			{0,1},
			{1,0},
			{0,-1}
	};
	static int N, M;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		map = new int [N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		clean(r,c,d);
		System.out.println(cnt);
	}
	private static void clean(int x, int y, int d) {
		if(map[x][y]==1) return;
		if(map[x][y]==0) {
			map[x][y]=2;
			cnt+=1;
		}
		for (int i = 0; i < 4; i++) {
			d=d==0?3:d-1;
			int nx = x+dir[d][0];
			int ny = y+dir[d][1];
			if(map[nx][ny]==0) {
				clean(nx,ny,d);
				return;
			}
		}
		int nx = x-dir[d][0];
		int ny = y-dir[d][1];
		clean(nx,ny,d);
		
		
		
	}

}