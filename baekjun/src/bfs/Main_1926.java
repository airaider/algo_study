package bfs;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1926 {
	static int N,M;
	static int[][] map;
	static int[][] dir={
		{1,0},
		{-1,0},
		{0,-1},
		{0,1}
	};
	static int max=0;
	static boolean[][] visit;
	static Queue<Point> q;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		int cnt=0;
		q = new LinkedList<Point>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==1 && !visit[i][j]) {
					visit[i][j]=true;
					cnt++;
					q.add(new Point(i,j));
					bfs();
				}
			}
		}
		System.out.println(cnt);
		System.out.println(max);
		
	}
	
	private static void bfs() {
		int c=1;
		while(!q.isEmpty()) {
			Point a = q.remove();
			int x = a.x;
			int y = a.y;
			for(int i=0;i<4;i++) {
				int nx=x+dir[i][0];
				int ny=y+dir[i][1];
				if(0<=nx && nx<N && 0<=ny && ny<M ) {
					if(map[nx][ny]==1 && !visit[nx][ny]) {
						visit[nx][ny]=true;
						c++;
						q.add(new Point(nx,ny));
					}
				}
			}
		}
		if(c>max) {
			max=c;
		}
		
		
	}

}
