package baekjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2589_보물섬 {
	static int N,M;
	static char[][] map;
	static boolean[][] visit;
	static int[][] dir = {
			{1,0},
			{-1,0},
			{0,-1},
			{0,1}
	};
	static int ans = 0;
	static Queue<Point> q = new LinkedList<Point>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]=='L') {
					clear();
					search(i,j);
				}
				
			}
		}
		System.out.println(ans);
	}
	private static void search(int a, int b) {
		q.add(new Point(a,b));
		visit[a][b]=true;
		Point p;
		int cnt=0;
		int x,y,nx,ny;
		while(!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				p = q.remove();
				x = p.x;
				y = p.y;
				for (int i = 0; i < 4; i++) {
					nx = x+dir[i][0];
					ny = y+dir[i][1];
					if(nx<0 || nx >=N || ny<0 || ny>=M) continue;
					if(map[nx][ny]=='L' && !visit[nx][ny]) {
						visit[nx][ny]=true;
						q.add(new Point(nx,ny));
					}
				}
				
			}
			cnt++;
		}
		if(cnt-1>ans)ans=cnt-1;
		
	}
	private static void clear() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]=='L' && visit[i][j]) {
					visit[i][j]=false;
				}
				
			}
		}
	}

}
