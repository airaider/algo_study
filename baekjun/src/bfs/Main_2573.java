package bfs;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2573 {
	static int N,M;
	static int map[][];
	static int melt[][];
	
	static int dir[][]= {
			{1,0},
			{-1,0},
			{0,1},
			{0,-1}
	};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		while(true) {
			melt = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j]!=0) {
						check(i,j);
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j]-melt[i][j]>0) {
						map[i][j]-=melt[i][j];
					}
					else {
						map[i][j]=0;
					}
				}
			}
			melt = new int[N][M];
			if(istwo()) break;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
		
	}
	private static boolean istwo() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]!=0) {
					check2(i,j);
					break;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(melt[i][j]!=0) {
					return false;
				}
			}
		}
		return true;
	}
	private static void check2(int a, int b) {
		for(int i=0;i<4;i++) {
			int nx=a+dir[i][0];
			int ny=b+dir[i][1];
			if (0 <= nx && nx < N && 0 <= ny && ny < M) {
				if (map[nx][ny] != 0) {
					check2(nx,ny);
				}
			}
		}
		
	}
	private static void check(int x, int y) {
		int cnt=0;
		for(int i=0;i<4;i++) {
			int nx=x+dir[i][0];
			int ny=y+dir[i][1];
			if (0 <= nx && nx < N && 0 <= ny && ny < M) {
				if (map[nx][ny] == 0) {
					cnt++;
				}
			}
		}
		melt[x][y]=cnt;
	}

}
