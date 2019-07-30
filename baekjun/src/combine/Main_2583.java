package combine;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_2583 {
	static int N,M,K;
	static int [][] map;
	static int [][] dir= {
			{1,0},
			{-1,0},
			{0,1},
			{0,-1}
	};
	static int count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M=sc.nextInt();
		N=sc.nextInt();
		map = new int [N][M];
		K=sc.nextInt();
		for(int k=0;k<K;k++) {
			int lx=sc.nextInt();
			int ly=sc.nextInt();
			int rx=sc.nextInt();
			int ry=sc.nextInt();
			for(int i=lx;i<rx;i++) {
				for(int j=ly;j<ry;j++) {
					map[i][j]=1;
				}
			}
		}
		
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		int island=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==0) {
					island++;
					count=0;
					map[i][j]=1;
					count++;
					spread(i,j);
					q.add(count);
				}
			}
		}
		System.out.println(island);
		while(!q.isEmpty()) {
			System.out.print(q.remove()+" ");
		}
	}
	private static void spread(int x, int y) {
		for(int i=0;i<4;i++) {
			int nx=x+dir[i][0];
			int ny=y+dir[i][1];
			if(0<=nx && nx<N && 0<=ny && ny<M) {
				if(map[nx][ny]==0) {
					map[nx][ny]=1;
					count++;
					spread(nx,ny);
				}
			}
		}
		
	}

}
