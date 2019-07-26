package bfs;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1012 {
	static int N,M,B;
	static int[][] map;
	static int[][] dir= {
			{1,0},
			{-1,0},
			{0,1},
			{0,-1}
	};
	static Queue<Point> q;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=0;t<T;t++) {
			int cnt=0;
			N=sc.nextInt();
			M=sc.nextInt();
			B=sc.nextInt();
			map = new int [N][M];
			for(int i=0;i<B;i++) {
				int a=sc.nextInt();
				int b=sc.nextInt();
				map[a][b]=1;
			}
			q = new LinkedList<Point>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j]==1) {
						map[i][j]=0;
						q.add(new Point(i,j));
						bfs();
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
	private static void bfs() {
		while(!q.isEmpty()) {
			Point p = q.remove();
			int x=p.x;
			int y=p.y;
			for(int i=0;i<4;i++) {
				int nx=x+dir[i][0];
				int ny=y+dir[i][1];
				if(0<=nx && nx<N && 0<=ny && ny<M) {
					if(map[nx][ny]==1) {
						map[nx][ny]=0;
						q.add(new Point(nx,ny));
					}
				}
			}
		}
	}

}
