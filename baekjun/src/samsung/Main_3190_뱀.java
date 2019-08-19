package samsung;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_3190_뱀 {
	static int map[][];
	static boolean trace[][];
	static movement move[];
	static int N,K,L;
	static int dir[][]={
		{0,1},
		{1,0},
		{0,-1},
		{-1,0}
	};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		map = new int [N][N];
		trace = new boolean[N][N];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x-1][y-1] = 1;
		}
		L = Integer.parseInt(br.readLine());
		move = new movement[L];
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			char y = st.nextToken().charAt(0);
			move[i]=new movement(x,y);
		}
		LinkedList<Point> snake = new LinkedList<Point>();
		snake.add(new Point(0,0));
		int d = 0;
		int s = 0;
		trace[0][0]=true;
		int time = 0;
		while(true) {
			if(s<move.length && time==move[s].time) {
				if(move[s].move=='D') {
					d=(d==3)?0:d+1;
				}
				else if(move[s].move=='L') {
					d=(d==0)?3:d-1;
				}
				s++;
			}
			Point p = snake.getFirst();
			int nx = p.x+dir[d][0];
			int ny = p.y+dir[d][1];
			if(nx<0 || nx>=N || ny<0 || ny>=N) break;
			if(trace[nx][ny]) break;
			if(map[nx][ny]==1) {
				trace[nx][ny]=true;
				map[nx][ny]=0;
				snake.addFirst(new Point(nx,ny));
				time++;
				continue;
			}
			trace[nx][ny]=true;
			snake.addFirst(new Point(nx,ny));
			p = snake.removeLast();
			trace[p.x][p.y]=false;
			time++;
		}
		System.out.println(time+1);
		
	}

}
class movement{
	int time;
	char move;
	public movement(int time, char move) {
		this.time=time;
		this.move=move;
	}
}