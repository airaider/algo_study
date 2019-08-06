package bfs;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3197 {
	static int dir[][]= {
			{1,0},
			{-1,0},
			{0,1},
			{0,-1}
	};
	static int N,M;
	static int [][] map;
	static int [][] next;
	static int px,py;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				switch (line.charAt(j)) {
				case '.':
					map[i][j]=0;
					break;
				case 'X':
					map[i][j]=1;				
					break;
				case 'L':
					map[i][j]=2;
					px=i;
					py=j;
					break;
				default:
					break;
				}
			}
		}
		
		int cnt=0;
		while(true) {
			melt();	
			cnt++;
			if(!check()) {
				break;
			}
		}
		System.out.println(cnt);
	}
	private static boolean check() {
		Queue<Point> q = new LinkedList<Point>();
		boolean[][] visit = new boolean[N][M];
		q.add(new Point(px,py));
		while(!q.isEmpty()) {
			Point p = q.remove();
			int x = p.x;
			int y = p.y;
			visit[x][y]=true;
			for(int i=0;i<4;i++) {
				int nx = x+dir[i][0];
				int ny = y+dir[i][1];
				if(0<=nx && nx<N && 0<=ny && ny<M && !visit[nx][ny]) {
					if(map[nx][ny]==2) {
						return true;
					}
					if(map[nx][ny]==0) {
						q.add(new Point(nx,ny));
					}
				}
			}
		}
		return false;
		
		
	}
	private static void melt() {
		next = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==1) {
					for(int k=0;k<4;k++) {
						int nx=i+dir[k][0];
						int ny=j+dir[k][1];
						if(0<=nx && nx<N && 0<=ny && ny<M) {
							if(map[nx][ny]==0) {
								next[i][j]=-1;
								break;
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(next[i][j]!=0) {
					map[i][j]+=next[i][j];
				}
			}
		}		
	}

}
