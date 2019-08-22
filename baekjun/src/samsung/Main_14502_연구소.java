package samsung;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502_연구소{
	static int N,M;
	static int map[][];
	static int ans=0;
	static Queue<Point> q= new LinkedList<Point>();;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int temp[][] = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				temp[i][j] = map[i][j];
			}
		}
		dfs(0,temp);
		System.out.println(ans);
		
	}
	private static void dfs(int index, int[][] temp) {
		if(index==3) {
			bfs(temp);
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(temp[i][j]==0) {
					temp[i][j]=1;
					dfs(index+1, temp);
					temp[i][j]=0;
				}
			}
		}
		
	}
	private static void bfs(int[][] temp) {
		int[][] test = new int [N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				test[i][j]=temp[i][j];
				if(temp[i][j]==2) {
					q.add(new Point(i,j));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Point p = q.remove();
			int x=p.x;
			int y=p.y;
			if(0 <= x-1 && test[x-1][y] == 0) { // 상
				test[x-1][y]=2;
				q.add(new Point(x-1,y));
			}
			if(x+1 < N && test[x+1][y] == 0) { // 하
				test[x+1][y]=2;
				q.add(new Point(x+1,y));
			}
			if(0 <= y-1 && test[x][y-1] == 0) { // 좌
				test[x][y-1]=2;
				q.add(new Point(x,y-1));
			}
			if(y+1 < M && test[x][y+1] == 0) { // 우
				test[x][y+1]=2;
				q.add(new Point(x,y+1));
			}
		}
		int cnt=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(test[i][j]==0) {
					cnt++;
				}
			}
		}
		if(cnt>ans) ans=cnt;
		return;
		
		
	}

}
