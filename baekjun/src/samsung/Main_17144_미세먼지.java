package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17144_미세먼지 {
	static int N,M;
	static int T;
	static int dir[][] = {
			{1,0},
			{-1,0},
			{0,1},
			{0,-1}
	};
	static int [][] map;
	static int [][] temp;
	static int locx, locy;
	static int sum=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==-1) {
					locx=i;
					locy=j;
				}
			}
		}
		while(T-->0) {
			spread();
			clean();
		}
		count();
		System.out.println(sum);
				
				
	}
	private static void count() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sum+=map[i][j];
			}
		}
		sum+=2;
	}
	private static void clean() {
		temp=new int [N][M];
		int x=locx;
		int y=locy;
		y=y+1;
		for (int i = y; i < M-1; i++) {
			temp[x][i+1]=map[x][i];
		}
		for (int i = x; i < N-1; i++) {
			temp[i+1][M-1]=map[i][M-1];
		}
		for(int i = M-1;i>0;i--) {
			temp[N-1][i-1]=map[N-1][i];
		}
		for(int i=N-1;i>x;i--) {
			temp[i-1][0]=map[i][0];
		}
		x= locx-1;
		for (int i = y; i < M-1; i++) {
			temp[x][i+1]=map[x][i];
		}
		for(int i=x;i>0;i--) {
			temp[i-1][M-1]=map[i][M-1];
		}
		for(int i = M-1;i>0;i--) {
			temp[0][i-1]=map[0][i];
		}
		for (int i = 0; i < x; i++) {
			temp[i+1][0]=map[i][0];
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(i==0 || i==N-1 || j==0 || j==M-1 || i==x || i ==x+1) {
					if(map[i][j]==-1) continue;
					map[i][j]=temp[i][j];
				}
			}
		}
		
		
		
	}
	private static void spread() {
		temp=new int [N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]!=0 && map[i][j]!=-1 && map[i][j]>=5) {
					int cnt=0;
					for(int k=0;k<4;k++) {
						int nx=i+dir[k][0];
						int ny=j+dir[k][1];
						if(nx<0 || nx>=N || ny <0 || ny>=M || map[nx][ny]==-1) continue;
						cnt++;
						temp[nx][ny]+=map[i][j]/5;
					}
					temp[i][j]+=map[i][j]-(map[i][j]/5)*cnt;
				}else if(map[i][j]!=0){
					temp[i][j]+=map[i][j];
				}
				
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j]=temp[i][j];
			}
	
		}
	}
}
