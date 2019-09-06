package SEA;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5650_핀볼게임 {
	static int N;
	static int[][] map;
	static int fx,fy;
	static int dir;
	static int d[][] = {
			{-1,0},
			{1,0},
			{0,1},
			{0,-1}
	};
	static int current;
	static int cnt;
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			ans=0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());

				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]==0) {
						for (int a = 0; a <= 3; a++) {
							dir = a;
							cnt=0;
							fx=i;
							fy=j;
							int x = fx;
							int y = fy;
							loop:
								while(true) {
									x+=d[dir][0];
									y+=d[dir][1];
									if(x==-1) {
										dir=1;
										cnt++;
										continue;
									}
									if(x==N) {
										dir=0;
										cnt++;
										continue;
									}
									if(y==-1) {
										dir=2;
										cnt++;
										continue;
									}
									if(y==N) {
										dir=3;
										cnt++;
										continue;
									}
									if(x==fx && y==fy) {
										if(cnt>ans) ans = cnt;
										break loop;
									}
									current = map[x][y];
									switch (current) {
									case 0:
										continue;
									case -1:
										if(cnt>ans) ans = cnt;
										break loop;
									case 1:
										switch (dir) {
										case 0:
											dir=1;
											break;
										case 1:
											dir=2;
											break;
										case 2:
											dir=3;
											break;
										case 3:
											dir=0;
											break;
										}
										cnt++;
										break;
									case 2:
										switch (dir) {
										case 0:
											dir=2;
											break;
										case 1:
											dir=0;
											break;
										case 2:
											dir=3;
											break;
										case 3:
											dir=1;
											break;
										}
										cnt++;
										break;
									case 3:
										switch (dir) {
										case 0:
											dir=3;
											break;
										case 1:
											dir=0;
											break;
										case 2:
											dir=1;
											break;
										case 3:
											dir=2;
											break;
										}
										cnt++;
										break;
									case 4:
										switch (dir) {
										case 0:
											dir=1;
											break;
										case 1:
											dir=3;
											break;
										case 2:
											dir=0;
											break;
										case 3:
											dir=2;
											break;
										}
										cnt++;
										break;
									case 5:
										switch (dir) {
										case 0:
											dir=1;
											break;
										case 1:
											dir=0;
											break;
										case 2:
											dir=3;
											break;
										case 3:
											dir=2;
											break;
										}
										cnt++;
										break;
									case 6:
										worm:
											for (int r = 0; r < N; r++) {
												for (int c = 0; c < N; c++) {
													if(map[r][c]==6 && !(x==r && y==c)) {
														x=r;
														y=c;
														break worm;
													}
												}
											}
									break;
									case 7:
										worm:
											for (int r = 0; r < N; r++) {
												for (int c = 0; c < N; c++) {
													if(map[r][c]==7 && !(x==r && y==c)) {
														x=r;
														y=c;
														break worm;
													}
												}
											}
									break;
									case 8:
										worm:
											for (int r = 0; r < N; r++) {
												for (int c = 0; c < N; c++) {
													if(map[r][c]==8 && !(x==r && y==c)) {
														x=r;
														y=c;
														break worm;
													}
												}
											}
									break;
									case 9:
										worm:
											for (int r = 0; r < N; r++) {
												for (int c = 0; c < N; c++) {
													if(map[r][c]==9 && !(x==r && y==c)) {
														x=r;
														y=c;
														break worm;
													}
												}
											}
									break;
									case 10:
										worm:
											for (int r = 0; r < N; r++) {
												for (int c = 0; c < N; c++) {
													if(map[r][c]==10 && !(x==r && y==c)) {
														x=r;
														y=c;
														break worm;
													}
												}
											}
									break;
									default:
										break;
									}
									
									
								}//loop
							
						}
					}
				}
			}
			System.out.println("#"+t+" "+ans);
		}
		
		
	}

}
