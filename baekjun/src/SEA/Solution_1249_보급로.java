package SEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution_1249_보급로 {
	static int[][] dir = {
			{1,0},
			{-1,0},
			{0,1},
			{0,-1}
	};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			boolean[][] visit = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				String line= br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = line.charAt(j)-'0';
				}
			}
			PriorityQueue<car> pq = new PriorityQueue<>();
			pq.add(new car(0,0,0));
			while(true) {
				car c = pq.poll();
				int x = c.x;
				int y = c.y;
				int d = c.de;
				if(x==N-1 && y==N-1) {
					System.out.println(d);
					break;
				}
				visit[x][y]=true;
				for (int i = 0; i < 4; i++) {
					int nx = x+dir[i][0];
					int ny = y+dir[i][1];
					if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
					if(!visit[nx][ny]) {
						pq.add(new car(nx,ny,d+map[nx][ny]));
					}
				}
				
			}
			
		}
		
	}
	static class car implements Comparable<car>{
		int x;
		int y;
		int de;
		public car(int x, int y, int de) {
			this.x = x;
			this.y = y;
			this.de = de;
		}
		@Override
		public int compareTo(car o) {
            return Integer.compare(this.de, o.de);
        }
		
	}
}
