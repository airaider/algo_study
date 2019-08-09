package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15683 {
	static int N,M;
	static int map[][];
	static boolean visit[][];
	static int dir[][] = {
			{1,0},
			{0,1},
			{-1,0},
			{0,-1}
	};
	static int permu[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		int how=0;
		ArrayList <Integer> what = new ArrayList <Integer>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==6) {
					visit[i][j]=true;
				}
				else if(map[i][j]!=0) {
					how++;
					what.add(map[i][j]);
				}
			}
		}
		int permu[] = new int [how];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==1) {
					scan(i,j,map[i][j]);
				}
			}
		}
		System.out.println();
		int cnt=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!visit[i][j]) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		
	}
	private static void scan(int x, int y, int cctv) {
		visit[x][y]=true;
		int tx=x;
		int ty=y;
		for(int i=0;i<4;i++) {
			x=tx;
			y=ty;
			while(true) {
				int nx = x+dir[i][0];
				int ny = y+dir[i][1];
				if(0>nx || nx>=N || 0>ny || ny>=M) break;
				if(map[nx][ny]==6) break;
				else {
					visit[nx][ny]=true;
					x=nx;
					y=ny;
				}
			}
			
		}
		
	}

}
