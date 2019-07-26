package bfs;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2178 {
	static int N,M;
	static int[][] map;
	static int[][] dir={
		{1,0},
		{-1,0},
		{0,-1},
		{0,1}
	};
	static int c=1;
	static int min=Integer.MAX_VALUE;
	static Queue<Point> q;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String s =sc.nextLine();
			for (int j = 0; j < M; j++) {
				map[i][j]=s.charAt(j)-'0';
			}
		}
		q = new LinkedList<Point>();
		q.add(new Point(0,0));
		map[0][0]=1;
		qbfs();
		System.out.println(map[N-1][M-1]);
	}
	
	private static void qbfs() {
		while(!q.isEmpty()) {
			Point p = q.remove();
			int x = p.x;
			int y = p.y;
			for(int i=0;i<4;i++) {
				int nx=x+dir[i][0];
				int ny=y+dir[i][1];
				if(0<=nx && nx<N && 0<=ny && ny<M ) {
					if(map[nx][ny]==1) {
						c++;
						if(nx==N-1 && ny==M-1) {
							if(map[nx][ny]<map[x][y]+1)
								map[nx][ny]=map[x][y]+1;
						}
						else{
							map[nx][ny]=map[x][y]+1;
							q.add(new Point(nx,ny));
						}
						
					}
					
					
					
		}
		}
	}
	}
	

}
