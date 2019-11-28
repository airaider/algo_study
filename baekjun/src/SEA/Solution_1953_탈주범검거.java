package SEA;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953_탈주범검거 {
	static int N,M,R,C,L;
	static int map[][];
//	static int dir[][] = {
//			{1,0},
//			{0,1},
//			{-1,0},
//			{0,-1}
//	};
	static boolean visit[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visit = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			Queue<Point> q = new LinkedList<>();
			q.add(new Point(R,C));
			int cnt=0;
			while(L-->0) {
				for (int s = 0, size=q.size(); s < size; s++) {
					Point p = q.remove();
					int x = p.x;
					int y = p.y;
					visit[x][y]=true;
					switch (map[x][y]) {
					case 1:
						if(x+1<N && !visit[x+1][y] && map[x+1][y]!=0) {
							if(map[x+1][y]!=3 && map[x+1][y]!=5 && map[x+1][y]!=6) {
								q.add(new Point(x+1,y));
							}
						}
						if(x-1>=0 && !visit[x-1][y] && map[x-1][y]!=0) {
							if(map[x-1][y]!=3 && map[x-1][y]!=4 && map[x-1][y]!=7) {
								q.add(new Point(x-1,y));
							}
						}
						if(y+1<M && !visit[x][y+1] && map[x][y+1]!=0) {
							if(map[x][y+ 1]!=2 && map[x][y+1]!=4 && map[x][y+1]!=5) {
								q.add(new Point(x,y+1));
							}
						}
						if(y-1>=0 && !visit[x][y-1] && map[x][y-1]!=0) {
							if(map[x][y-1]!=2 && map[x][y-1]!=6 && map[x][y-1]!=7) {
								q.add(new Point(x,y-1));
							}
						}
						break;
					case 2:
						if(x+1<N && !visit[x+1][y] && map[x+1][y]!=0) {
							if(map[x+1][y]!=3 && map[x+1][y]!=5 && map[x+1][y]!=6) {
								q.add(new Point(x+1,y));
							}
						}
						if(x-1>=0 && !visit[x-1][y] && map[x-1][y]!=0) {
							if(map[x-1][y]!=3 && map[x-1][y]!=4 && map[x-1][y]!=7) {
								q.add(new Point(x-1,y));
							}
						}
						break;
					case 3:
						if(y+1<M && !visit[x][y+1] && map[x][y+1]!=0) {
							if(map[x][y+ 1]!=2 && map[x][y+1]!=4 && map[x][y+1]!=5) {
								q.add(new Point(x,y+1));
							}
						}
						if(y-1>=0 && !visit[x][y-1] && map[x][y-1]!=0) {
							if(map[x][y-1]!=2 && map[x][y-1]!=6 && map[x][y-1]!=7) {
								q.add(new Point(x,y-1));
							}
						}
						break;
					case 4:
						if(x-1>=0 && !visit[x-1][y] && map[x-1][y]!=0) {
							if(map[x-1][y]!=3 && map[x-1][y]!=4 && map[x-1][y]!=7) {
								q.add(new Point(x-1,y));
							}
						}
						if(y+1<M && !visit[x][y+1] && map[x][y+1]!=0) {
							if(map[x][y+ 1]!=2 && map[x][y+1]!=4 && map[x][y+1]!=5) {
								q.add(new Point(x,y+1));
							}
						}
						break;
					case 5:
						if(x+1<N && !visit[x+1][y] && map[x+1][y]!=0) {
							if(map[x+1][y]!=3 && map[x+1][y]!=5 && map[x+1][y]!=6) {
								q.add(new Point(x+1,y));
							}
						}
						if(y+1<M && !visit[x][y+1] && map[x][y+1]!=0) {
							if(map[x][y+ 1]!=2 && map[x][y+1]!=4 && map[x][y+1]!=5) {
								q.add(new Point(x,y+1));
							}
						}
						break;
					case 6:
						if(x+1<N && !visit[x+1][y] && map[x+1][y]!=0) {
							if(map[x+1][y]!=3 && map[x+1][y]!=5 && map[x+1][y]!=6) {
								q.add(new Point(x+1,y));
							}
						}
						if(y-1>=0 && !visit[x][y-1] && map[x][y-1]!=0) {
							if(map[x][y-1]!=2 && map[x][y-1]!=6 && map[x][y-1]!=7) {
								q.add(new Point(x,y-1));
							}
						}
						break;
					case 7:
						if(x-1>=0 && !visit[x-1][y] && map[x-1][y]!=0) {
							if(map[x-1][y]!=3 && map[x-1][y]!=4 && map[x-1][y]!=7) {
								q.add(new Point(x-1,y));
							}
						}
						if(y-1>=0 && !visit[x][y-1] && map[x][y-1]!=0) {
							if(map[x][y-1]!=2 && map[x][y-1]!=6 && map[x][y-1]!=7) {
								q.add(new Point(x,y-1));
							}
						}
						break;
					default:
						break;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(visit[i][j]) cnt++;
				}
			}
			System.out.println("#"+t+" "+cnt);
			
			
		}
		
		
	}

}
