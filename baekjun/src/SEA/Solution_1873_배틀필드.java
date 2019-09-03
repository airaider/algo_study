package SEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1873_배틀필드 {
	static int H,W;
	static int N;
	static int x,y;
	static int d;
	static char [] order;
	static char [][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			String line = "";
			for (int i = 0; i < H; i++) {
				line = br.readLine();
				for (int j = 0; j < W; j++) {
					char c = line.charAt(j);
					map[i][j]=c;
					if(c=='>') {
						x=i;
						y=j;
						d=1;
					}
					else if(c=='v') {
						x=i;
						y=j;
						d=2;
					}
					else if(c=='<') {
						x=i;
						y=j;
						d=3;
					}
					else if(c=='^') {
						x=i;
						y=j;
						d=0;
					}
						
				}
			}
			N = Integer.parseInt(br.readLine());
			order = new char[N];
			line = br.readLine();
			for (int i = 0; i < N; i++) {
				order[i]=line.charAt(i);
			}
			
			for (int i = 0; i < N; i++) {
				char what = order[i];
				switch (what) {
				case 'S':
					switch (d) {
					case 1:
						int ny=y+1;
						while(ny<W) {
							if(map[x][ny]=='#') break;
							if(map[x][ny]=='*') {
								map[x][ny]='.';
								break;
							}
							ny=ny+1;
						}
						break;
					case 2:
						int nx=x+1;
						while(nx<H) {
							if(map[nx][y]=='#') break;
							if(map[nx][y]=='*') {
								map[nx][y]='.';
								break;
							}
							nx=nx+1;
						}			
						break;
					case 3:
						ny=y-1;
						while(ny>=0) {
							if(map[x][ny]=='#') break;
							if(map[x][ny]=='*') {
								map[x][ny]='.';
								break;
							}
							ny=ny-1;
						}
						break;
					case 0:
						nx=x-1;
						while(nx>=0) {
							if(map[nx][y]=='#') break;
							if(map[nx][y]=='*') {
								map[nx][y]='.';
								break;
							}
							nx=nx-1;
						}
						break;
					default:
						break;
					}
					break;
				case 'U':
					d=0;
					if(x-1>=0 && map[x-1][y]=='.') {
						map[x][y]='.';
						x=x-1;
					}
					map[x][y]='^';
					break;
				case 'D':
					d=2;
					if(x+1<H && map[x+1][y]=='.') {
						map[x][y]='.';
						x=x+1;
					}
					map[x][y]='v';
					break;
				case 'L':
					d=3;
					if(y-1>=0 && map[x][y-1]=='.') {
						map[x][y]='.';
						y=y-1;
					}
					map[x][y]='<';
					break;
				case 'R':
					d=1;
					if(y+1<W && map[x][y+1]=='.') {
						map[x][y]='.';
						y=y+1;
					}
					map[x][y]='>';
					break;
				default:
					break;
				}
				
			}
			
			System.out.print("#"+t+" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
		
	}

}
