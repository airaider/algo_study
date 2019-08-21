package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503_호봇청소기 {
	static int map[][];
	static int dir[][]= {
			{-1,0},
			{0,1},
			{1,0},
			{0,-1}
	};
	static int N, M;
	static boolean visit[][];
	static int r,c,d;
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
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		clean();

	}
	private static void clean() {
		int x = r;
		int y = c;
		while(true) {
			
			visit[x][y]=true;
			d = d==0?3:d-1;
			int nx = x+dir[d][0];
			int ny = y+dir[d][1];
			if(nx>=0 && nx<N && ny>=0 && ny<M && !visit[nx][ny]) {
				x=nx;
				y=ny;
				continue;
			}
			
		}
	}

}
