package bfs;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class set {
	int x;
	int y;
	int cnt;
	set(int x, int y, int cnt){
		this.x=x;
		this.y=y;
		this.cnt=cnt;

	}
}

public class bfs_7562 {
	static int N;
	static int flag;
	static int[][] map;
	static boolean[][] visit;
	static int[][] dir= {
			{2,1},
			{2,-1},
			{1,2},
			{1,-2},
			{-2,1},
			{-2,-1},
			{-1,2},
			{-1,-2},
	};
	static int min;
	static int sx,sy;
	static int fx,fy;
	static Queue<set> q;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		flag=0;
		for(int t=0;t<T;t++) {
			min = Integer.MAX_VALUE;
			N=sc.nextInt();
			map = new int[N][N];
			visit = new boolean[N][N];
			sx=sc.nextInt();
			sy=sc.nextInt();
			fx=sc.nextInt();
			fy=sc.nextInt();
			if(sx==fx && fx==fy) {
				System.out.println(0);
				continue;
			}
			q = new LinkedList<set>();
			q.add(new set(sx, sy, 0));
			bfs();
			System.out.println(flag);
		}
	}
	private static void bfs() {
		while(!q.isEmpty()) {
			set p = q.remove();
			int x=p.x;
			int y=p.y;
			int c=p.cnt;
			visit[x][y]=true;
			for(int i=0;i<8;i++) {
				int nx=x+dir[i][0];
				int ny=y+dir[i][1];
				if (0 <= nx && nx < N && 0 <= ny && ny < N) {
					if(nx==fx && ny ==fy) {
						flag=c+1;
						return;
					}
					if (!visit[nx][ny]) {
						visit[nx][ny]=true;
						q.add(new set(nx,ny,c+1));
					}
				}
				
			}
		}
		
		
	}

}

/*
1
8
0 0
7 0

3
8
0 0
7 0
100
0 0
30 50
10
1 1
1 1
*/