package simul;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class simul_5427 {
	static int stoi(String s) {
		return Integer.parseInt(s);
	}
	static int[][] dir ={{-1,0},{1,0},{0,-1},{0,1}};
	static int N,M;
	static char[][] map;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("5427.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = stoi(st.nextToken());
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			M=stoi(st.nextToken());
			N=stoi(st.nextToken());
			Queue<Point> p = new LinkedList<Point>();
			map = new char [N][M];
			for (int i = 0; i < N; i++) {
				String a = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j]=a.charAt(j);
					if(a.charAt(j)=='@') {
						p.add(new Point(i,j));
					}
				}
			}
			show();
			
			while(!p.isEmpty()) {
				
				break;
			}
			
			
		}
		
	}
	
	private static void fire() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]=='*') {	
					spread(i,j,'*');
					break;
				}
			}
		}
	}

	private static void find() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]=='@') {	
					spread(i,j,'@');
					break;
				}
			}
		}
		
	}

	private static void spread(int x, int y, char c) {
		for(int i=0;i<4;i++) {
			int nx=x+dir[i][0];
			int ny=y+dir[i][1];
			if(0<=nx && nx<N &&0<=ny && ny<M) {
				if(map[nx][ny]=='.') {
					map[nx][ny]=c;
				}
				if(map[nx][ny]=='@') {
					map[nx][ny]=c;
				}
			}
		}
	}

	private static void show() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
	}

}