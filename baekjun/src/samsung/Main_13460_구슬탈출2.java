package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13460_구슬탈출2 {
	static int N,M;
	static char map[][];
	static Queue<move> q = new LinkedList<move>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if(str.charAt(j)=='R') {
					q.add(new move(i,j,'R'));
				}
				else if(str.charAt(j)=='B') {
					q.add(new move(i,j,'B'));
				}
				else if(str.charAt(j)=='O') {
					
				}
			}
		}
		tilt();
		
		
	}
	private static void tilt() {
		
		move p1 = q.remove();
		move p2 = q.remove();
		int x=p1.x;
		int y=p1.y;
		for (int i = 0; i < 4; i++) {
			while(true) {
				if(map[x-1][y]=='.') {
					x=x-1;
				}
				else if(map[x-1][y]=='#') break;
				else if(map[x-1][y]=='O') break;
				else break;
			}
			
		}
		
	}

}
class move{
	int x;
	int y;
	char c;
	move(int x, int y, char c){
		this.x=x;
		this.y=y;
		this.c=c;
	}
}
