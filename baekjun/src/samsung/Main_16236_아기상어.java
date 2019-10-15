package samsung;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.Point;
import java.util.StringTokenizer;

public class Main_16236_아기상어 {

	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int[][] dir= {
			{-1,0},
			{0,-1},
			{0,1},
			{1,0}
	};
	static int fx,fy;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					fx=i;
					fy=j;
				}
			}
		}
		int shark=2;
		int size=0;
		int time=0;
		while(true) {
//			System.out.println("shark:"+shark+" size:"+size+" time:"+time);
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(map[i][j]+" ");
//				}
//				System.out.println();
//			}
			ArrayList<Pd> po = new ArrayList<>();
			visit = new boolean[N][N];
			visit[fx][fy]=true;
			boolean flag=false;
			Queue<Point> q = new LinkedList<>();
			q.add(new Point(fx,fy));
			int cnt=0;
			while(!q.isEmpty()) {
				cnt++;
				for(int s = 0,len=q.size();s<len;s++) {
					Point p = q.poll();
					int x = p.x;
					int y = p.y;
					for (int i = 0; i < 4; i++) {
						int nx = x+dir[i][0];
						int ny = y+dir[i][1];
						if(nx<0 || nx>=N || ny<0 || ny>=N || visit[nx][ny]) continue;
						if(map[nx][ny]<=shark) {
							visit[nx][ny]=true;
							if(map[nx][ny]==0 || map[nx][ny]==shark) {
								q.add(new Point(nx,ny));
							}else if(map[nx][ny]<shark){
								po.add(new Pd(nx,ny));
								flag=true;
							}
						}
					}
				}
				if(flag) break;
			}
			if(!flag) break;
			Collections.sort(po);
			map[fx][fy]=0;
			int x = po.get(0).x;
			int y = po.get(0).y;
			map[x][y]=9;
			time+=cnt;
			fx=x;
			fy=y;
			size++;
			if(size==shark) {
				shark++;
				size=0;
			}
			
		}
		System.out.println(time);
		
	}
	private static class Pd implements Comparable<Pd>{
		int x;
		int y;
		
		public Pd(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Pd o) {
			int a = this.x-o.x;
			if(a==0) {
				return this.y-o.y;
			}
			return a;
		}
		
	}
}
