package simul;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class simul_16000 {
	static int[][] dir= {
			{1,0},
			{-1,0},
			{0,1},
			{0,-1}
	};
	static int N,M;
	static int[][] map;
	static Queue<Point> island;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("16000.txt"));
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		sc.nextLine();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String st = sc.nextLine();
			for (int j = 0; j < M; j++) {
				if(st.charAt(j)=='.') map[i][j]=0;
				else map[i][j]=-1;
			}
		}
		int c=1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==-1) {
					spread(i,j,c);
					c++;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]>0 ) {
					boolean[][] visit = new boolean[N][M];
//					bfs(i,j);
				}
			}
		}
		show();
		
	}

	private static void spread(int x, int y, int k) {
		island = new LinkedList<Point>();
		island.add(new Point(x,y));
		map[x][y]=k;
		while(!island.isEmpty()) {
			Point pt = island.remove();
			int a=pt.x;
			int b=pt.y;
			for(int i=0;i<4;i++) {
				int nx=a+dir[i][0];
				int ny=b+dir[i][1];
				if(0<=nx && nx<N && 0<=ny && ny<M) {
					if(map[nx][ny]<0) {
						map[nx][ny]=k;
						island.add(new Point(nx,ny));
					}
					
				}
				
			}
		}
		
	}

	private static void bfs() {
		
		return;
	}

	private static void show() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
	}

}
