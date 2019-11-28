package baekjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3055_탈출 {
	static int R,C;
	static char map[][];
	static int[][] dir= {
			{1,0},{-1,0},{0,1},{0,-1}
	};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		Queue<Point> q = new LinkedList<>();
		Queue<Point> water = new LinkedList<>();
		
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j]=input.charAt(j);
				if(map[i][j]=='S') {
					q.add(new Point(i,j));
				}
				else if(map[i][j]=='*') {
					water.add(new Point(i,j));
				}
			}
		}
		int count=0;
		while(true) {
			count++;
			if(q.isEmpty()) {
				System.out.println("KAKTUS");
				return;
			}
			for (int s = 0, size=q.size(); s < size; s++) {
				Point p = q.remove();
				int x = p.x;
				int y = p.y;
				if(map[x][y]=='*') continue;
				for (int i = 0; i < 4; i++) {
					int nx = x+dir[i][0];
					int ny = y+dir[i][1];
					if(nx>=R || nx<0 || ny>=C || ny<0) continue;
					if(map[nx][ny]=='.') {
						map[nx][ny]='S';
						q.add(new Point(nx,ny));
					}
					if(map[nx][ny]=='D') {
						System.out.println(count);
						return;
					}
				}
			}
			for (int s = 0, size=water.size(); s < size; s++) {
				Point p = water.remove();
				int x = p.x;
				int y = p.y;
				for (int i = 0; i < 4; i++) {
					int nx = x+dir[i][0];
					int ny = y+dir[i][1];
					if(nx>=R || nx<0 || ny>=C || ny<0) continue;
					if(map[nx][ny]=='.' || map[nx][ny]=='S') {
						map[nx][ny]='*';
						water.add(new Point(nx,ny));
					}
				}
			}
			
		}
		
		
	}

}
