package bfs;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Three {
	int x;
	int y;
	int z;
	Three(int a, int b, int c) {
		this.x=a;
		this.y=b;
		this.z=c;
	}
}

public class bfs_7569 {
	static int[][][] map;
	static int[][][] visit;
	static int[][] dir={
		{1,0,0},
		{-1,0,0},
		{0,1,0},
		{0,-1,0},
		{0,0,1},
		{0,0,-1}
	};
	static int M,N,H;
	static Queue<Three> q;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		H=sc.nextInt();
		map = new int[N][M][H];
		visit = new int[N][M][H];
		q=new LinkedList<Three>();
		for (int k = 0; k <H; k++) {
			for (int j = 0; j < M; j++) {
				for (int i = 0; i < N; i++) {
					map[i][j][k]=sc.nextInt();
					visit[i][j][k]=-1;
					if(map[i][j][k]==1) {
						visit[i][j][k]=0;
						q.add(new Three(i,j,k));
					}
				}
			}
		}
		
		bfs();
		check();
		
		
		
	}
	
		
	private static void check() {
		int max=-1;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				for(int k=0;k<H;k++) {
					if(map[i][j][k]==0) {
						System.out.println("-1");
						return;
					}
					if(visit[i][j][k]>max)max=visit[i][j][k];
				}
				
			}
		}
		System.out.println(max);
		return;
		
		
	}
	
	private static void bfs() {
		while(!q.isEmpty()) {
			Three a = q.remove();
			int x=a.x;
			int y=a.y;
			int z=a.z;
			for(int i=0;i<6;i++) {
				int nx=x+dir[i][0];
				int ny=y+dir[i][1];
				int nz=z+dir[i][2];
				if(0<=nx && nx<N && 0<=ny && ny<M && 0<=nz && nz<H) {
					if(map[nx][ny][nz]==0 && visit[nx][ny][nz]==-1) {
						map[nx][ny][nz]=1;
						visit[nx][ny][nz]=visit[x][y][z]+1;
						q.add(new Three(nx,ny,nz));
					}
				}
				
			}
		}
	}
}

		