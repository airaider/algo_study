package bfs;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class bfs_7576 {
	static int stoi(String s) { return Integer.parseInt(s);}
	static int N;
	static int M;
	static int cnt=0;
	static int[] dirR= {-1,1,0,0};		
	static int[] dirC= {0,0,-1,1};		
	static int[][] map;
	static Queue<Point> q = new LinkedList<Point>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	    M = stoi(st.nextToken());
	    N = stoi(st.nextToken());
	    map = new int[N][M];
	    for (int i = 0; i < N; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	for (int j = 0; j < M; j++) {
				map[i][j]=stoi(st.nextToken());
			}
		}
	    for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==1) {
					q.add(new Point(i,j));
				}	
			}
			
		}
	    bfs();
	    while(!q.isEmpty()) {
	    	System.out.println(q.poll());
	    }
	    System.out.println(check());
	}
	

	private static int check() {
		int max=-1;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) {
					return -1;
				}
				if(map[i][j]>max)max=map[i][j];
			}
		}
		return max-1;
		
	}

	private static void bfs() {
		while(!q.isEmpty()) {
			Point p = q.remove();
			int x=p.x;
			int y=p.y;
			for(int i=0;i<4;i++) {
				int nr = x+dirR[i];
				int nc = y+dirC[i];
				
				if(0<=nr && nr<N && 0<=nc && nc<M ) {
					if(map[nr][nc]==0) {
						map[nr][nc]=map[x][y]+1;
						q.add(new Point(nr,nc));
					}
					
				}
			}
			
			
		}
	}
}
		