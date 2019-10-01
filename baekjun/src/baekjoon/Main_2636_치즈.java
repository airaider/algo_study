package baekjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636_치즈 {
	static int N,M;
	static int map[][];
	static int visit[][];
	static int dir[][]= { 
			{1,0},
			{-1,0},
			{0,1},
			{0,-1}
	};
	static int cnt=0;
	static Queue<Point> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int a=count();
		int b=0;
		while(true) {
			wind:
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if(map[i][j]==0) mark(i,j);
						break wind;
					}
				}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(visit[i][j]==1) map[i][j]=0;
			}
		}
		for (int i = 0; i < N; i++) {
			Arrays.fill(visit[i], 0);
		}
		cnt++;
		b=count();
		if(b==0)break;
		a=b;
		}
		System.out.println(cnt);
		System.out.println(a);
	}
	private static int count() {
		int c=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==1) c++;
			}
		}
		return c;
	}
	private static void mark(int a, int b) {
		q.add(new Point(a,b));
		visit[a][b]=-1;
		while(!q.isEmpty()) {
			Point p = q.remove();
			int x = p.x;
			int y = p.y;
			for (int i = 0; i < 4; i++) {
				int nx = x+dir[i][0];
				int ny = y+dir[i][1];
				if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
				if(map[nx][ny]==0 && visit[nx][ny]==0) {
					visit[nx][ny]=-1;
					q.add(new Point(nx,ny));
				}
				if(map[nx][ny]==1) visit[nx][ny]=1;
			}
		}
	}
}
