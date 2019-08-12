package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
	int x;
	int y;
	int day=0;
	Point(int x, int y){
		this.x=x;
		this.y=y;
	}
	Point(int x, int y, int c){
		this.x=x;
		this.y=y;
		this.day=c;
	}
}

public class Main_17142 {
	static int N,M;
	static int ans=Integer.MAX_VALUE;
	static int dir[][]= {
			{1,0},
			{-1,0},
			{0,1},
			{0,-1}
	};
	static int [][] map;
	static int [][] map2;
	
	static boolean [][] check; 
 	static boolean[] visit;
 	static ArrayList<Point> loc;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int [N][N];
		map2 = new int [N][N];
		loc = new ArrayList<Point>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					loc.add(new Point(i,j));
				}
				else if(map[i][j]==1) {
					map2[i][j]=1;
				}
			}
		}
		visit = new boolean [loc.size()];
		dfs(0,0);
		
		
	}
	private static void dfs(int v, int len) {
		if(len==M) {
			spread();
		}
		else {
			for (int i = v, cnt = loc.size(); i < cnt; i++) {
				if(!visit[i]) {
					visit[i]=true;
					dfs(i,len+1);
				}
			}
		}
		visit[v]=false;
		
	}
	private static void spread() {
		check = new boolean[N][N];
		Queue<Point> q = new LinkedList<Point>();
		for (int i = 0, cnt = loc.size(); i < cnt; i++) {
			if(visit[i]) {
				Point c = loc.get(i);
				q.add(c);
				check[c.x][c.y]=true;
			}
		}
		int d=0;
		while(!q.isEmpty()) {
			Point p = q.remove();
			int x = p.x;
			int y = p.y;
			int day = p.day;
			for(int i=0;i<4;i++) {
				int nx = dir[i][0]+x;
				int ny = dir[i][1]+y;
				if(0>nx || nx>=N || 0>ny || ny>=N) continue;
				if(map[nx][ny]!=1 && !check[nx][ny]) {
					if(map[nx][ny]==2) {
						check[nx][ny]=true;
						q.add(new Point(nx,ny, day));
					}
					else{
						check[nx][ny]=true;
						d=day+1;
						q.add(new Point(nx,ny, day+1));
					}
					
				}
				
			}
			
		}
		if(doublecheck()) System.out.println(d);
		
	}
	
	private static boolean doublecheck() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]!=1 && !check[i][j]) {
				return false;
				}
			}
		}
		return true;
		
	}

}
